package sdzee.com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.bdd.Database;
import sdzee.com.beans.Admin_global;
import sdzee.com.beans.Admin_local;

/**
 * Servlet implementation class Accueille_global
 */
@WebServlet("/Accueille_global")
public class Accueille_global extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueille_global() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ( session.getAttribute("session_global") == null ) {
			
	         	response.sendRedirect( request.getContextPath() +"/Loginusers");
	        } else {
	    	Admin_global r =(Admin_global)session.getAttribute("session_global");
	    	Database d=new Database();
	    	HashMap<String,List<String>> VilleHotel= d.ShowHotelVille();
	    	request.setAttribute("VilleHotel", VilleHotel);
	    	ArrayList<Admin_local> adminL=d.getAllAdminLocal();
	    	request.setAttribute("adminL",adminL);
	    	response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");
	    	this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilAdmin_global.jsp" ).forward( request, response );
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
