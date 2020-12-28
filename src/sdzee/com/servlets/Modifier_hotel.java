package sdzee.com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sdzee.com.beans.*;
import sdzee.com.bdd.*;


/**
 * Servlet implementation class Modifier_hotel
 */
@WebServlet("/Modifier_hotel")
public class Modifier_hotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_hotel() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database d=new Database();
		HashMap<String,List<String>> VilleHotel= d.ShowHotelVille();
		request.setAttribute("VilleHotel", VilleHotel);
		ArrayList<Integer> id_hotels=new ArrayList<Integer>();
		ArrayList<photos_hotel> photos=new ArrayList<photos_hotel>();
		for (HashMap.Entry<String,List<String>> villehotel : VilleHotel.entrySet()) {
			for (String hotel : villehotel.getValue()) {
				id_hotels.add(d.getId_hotelDb(villehotel.getKey(),hotel));
				photos.add(d.getphotoh(d.getId_hotelDb(villehotel.getKey(),hotel),1));
			}
		}         
	        request.setAttribute("photos",photos);
		request.setAttribute("id_hotels",id_hotels);
    		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_hotel.jsp").forward(request, response);
    			
	}
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	}
}
