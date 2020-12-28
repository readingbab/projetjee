package sdzee.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdzee.com.bdd.Database;
import sdzee.com.beans.Hoteldata;
import sdzee.com.beans.photos_hotel;

/**
 * Servlet implementation class gerer_hotel
 */
@WebServlet("/gerer_hotel")
public class gerer_hotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database d=new Database();
		int id_hotel=Integer.parseInt(request.getParameter("id_hotel"));
		Hoteldata hoteldata=d.getHotelData(id_hotel);
		ArrayList<photos_hotel> photos=new ArrayList<photos_hotel>();
		for(int i=0;i<3;i++) {
			photos.add(d.getphotoh(id_hotel,i+1));
		}
		request.setAttribute("hoteldata",hoteldata);
		request.setAttribute("photos",photos);
		boolean check=true;
		if (photos.get(1) == null) {
			check=false;
			}
		request.setAttribute("check",check);
		response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
		this.getServletContext().getRequestDispatcher("/WEB-INF/gerer_hotel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=Integer.parseInt(request.getParameter("id_hotel"));
			String nom=request.getParameter("nom");
			int nombre_etoile=Integer.parseInt(request.getParameter("nombre_etoile"));
			
			Database d=new Database();
			d.changeHotel(id, nom,nombre_etoile) ;
		response.sendRedirect( request.getContextPath() +  "/gerer_hotel?id_hotel="+id);
	}

}
