package sdzee.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.bdd.Database;
import sdzee.com.beans.Admin_local;
import sdzee.com.beans.Chambre;

/**
 * Servlet implementation class Accueille_local
 */
@WebServlet("/Accueille_local")
public class Accueille_local extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueille_local() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

    	if ( session.getAttribute("session_local") == null ) {
    			
	         	response.sendRedirect( request.getContextPath() +"/Loginusers");
	        } else {
    	Database d=new Database();
    	//HashMap<String,List<String>> VilleHotel= d.ShowHotelVille();
    	//request.setAttribute("VilleHotel", VilleHotel);
		Admin_local r =(Admin_local)session.getAttribute("session_local");
    	ArrayList<Chambre> receptionniste=d.getAllchambres(d.getId_hotelDb(r.getVille_hotel(), r.getNom_hotel()));
    	request.setAttribute("receptionniste",receptionniste);
    	d.annuler_reservation(d.getId_hotelDb(r.getVille_hotel(), r.getNom_hotel()));
    	response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilAdmin_local.jsp" ).forward( request, response );
	        }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
