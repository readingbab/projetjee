package sdzee.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sdzee.com.beans.*;
import sdzee.com.bdd.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Servlet implementation class gestion_reservations
 */
@WebServlet("/gestion_reservations")
public class gestion_reservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("session_receptionniste") == null && session.getAttribute("session_local") == null ) {
		
         	response.sendRedirect( request.getContextPath() +"/Loginusers");
        } else {
        Database d=new Database();
		String cin=request.getParameter("cin");
		String type=request.getParameter("type");
		int id_hotel=0;
		
		
    	if(session.getAttribute( "session_local")!=null){
    		Admin_local l=(Admin_local)session.getAttribute("session_local");
    		id_hotel=d.getId_hotelDb(l.getVille_hotel() ,l.getNom_hotel());
    	}else {
    	if(session.getAttribute("session_receptionniste")!=null) {
    		Receptionniste r=(Receptionniste)session.getAttribute("session_receptionniste");
    		id_hotel=d.getId_hotelDb(r.getVille_hotel() ,r.getNom_hotel());
    	
    	}}
    	ArrayList<Reservation> reservations=d.getReservations(cin,id_hotel,type);
    	request.setAttribute("reservations",reservations);
    	request.setAttribute("cin",cin);
    	response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");
	    //this.getServletContext().getRequestDispatcher( "/WEB-INF/gestion_reservations.jsp" ).forward( request, response );	
    	if(session.getAttribute( "session_local")!=null){
        	this.getServletContext().getRequestDispatcher( "/WEB-INF/gestion_reservations_local.jsp" ).forward( request, response );	

    	}else {
    	if(session.getAttribute("session_receptionniste")!=null) {
        	this.getServletContext().getRequestDispatcher( "/WEB-INF/gestion_reservations_recept.jsp" ).forward( request, response );	
    	
    	}}
    	
    	
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/gestion_reservations_recept.jsp" ).forward( request, response );	
       }	
       
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database d=new Database();
		String typeReservation=request.getParameter("type");
		int resultat =d.changereservation(request,typeReservation);
		System.out.println(resultat);
		String cin=request.getParameter("cin");
		String url="/gestion_reservations?cin="+cin+"&type=true";
		response.sendRedirect( request.getContextPath() +  url);
	}

}
