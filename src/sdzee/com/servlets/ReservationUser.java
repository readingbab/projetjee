package sdzee.com.servlets;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import sdzee.com.beans.Reservation;
import sdzee.com.bdd.Database;
import sdzee.com.beans.*;
public class ReservationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ( session.getAttribute("session_user")==null) {
			
         	response.sendRedirect( request.getContextPath() +"/loginservlet");
        } else {
		Database d=new Database();
		ArrayList<ReservationHotel> reservations=(ArrayList<ReservationHotel>)d.ShowReservation(request,(((Client) session.getAttribute("session_user")).getCin()));
		ArrayList<Float> ratings=new ArrayList<Float>();
		for( ReservationHotel r: reservations){
            ratings.add(d.getRating(r.getReservation().getId_reservation()));
        }
		for(float r: ratings){
            System.out.println(r);
        }
		request.setAttribute("reservations",reservations);
		request.setAttribute("ratings",ratings);
		response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
		Client c=(Client)session.getAttribute("session_user");
		d.annuler_reservationclient(c.getCin());
	    this.getServletContext().getRequestDispatcher( "/bootstrap-star-rating-master/examples/index.jsp" ).forward( request, response );
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database d=new Database();
		String typeReservation=request.getParameter("type");
		int resultat =d.changereservation(request,typeReservation);
		System.out.println(resultat);
		
		response.sendRedirect( request.getContextPath() +  "/reservationuser?type=true");
	}

}
