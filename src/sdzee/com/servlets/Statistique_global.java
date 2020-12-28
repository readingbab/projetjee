package sdzee.com.servlets;

import java.io.IOException;
import java.util.HashMap;

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
 * Servlet implementation class Statistique_global
 */
@WebServlet("/Statistique_global")
public class Statistique_global extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statistique_global() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 if ( session.getAttribute("session_global") == null ) {
			
	         	response.sendRedirect( request.getContextPath() +"/Loginusers");
	        } else {
	    		Admin_global r =(Admin_global)session.getAttribute("session_global");	
	    		
	    		Database add=new Database();
	    		//l=add.statistiqueHotel(add.getId_hotelDb(r.getVille_hotel(),r.getNom_hotel()));
	    		
	    		HashMap<Integer, Integer> map=add.statistiquegloballastemonth();
	    		HashMap<Integer, Integer> map1=add.statistiquegloballasteyear();
	    		
	    		
	    		request.setAttribute("map",map);
	    		request.setAttribute("map1",map1);
	    		response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");
	    		this.getServletContext().getRequestDispatcher("/WEB-INF/statistique_global.jsp").forward(request, response);
	        	
	        	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session = request.getSession();
		Admin_local r =(Admin_local)session.getAttribute("session_local");	
		int[] l=new int[12];
		Database add=new Database();
		//l=add.statistiqueHotel(add.getId_hotelDb(r.getVille_hotel(),r.getNom_hotel()));
		System.out.println("les statistique :::"+l);
		this.getServletContext().getRequestDispatcher("/WEB-INF/statistique_local.jsp").forward(request, response);
	*/
		
	doGet(request, response);
	}

}
