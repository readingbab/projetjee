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
import sdzee.com.beans.Client;

/**
 * Servlet implementation class Accueille_client
 */
@WebServlet("/Accueille_client")
public class Accueille_client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueille_client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ( session.getAttribute("session_user")==null) {
			
         	response.sendRedirect( request.getContextPath() +"/loginservlet");
        } else {
        	boolean reserved;
	    	if(session.getAttribute("reserved")==null){
	    		reserved=false;
	    	}
	    	else {
	    		reserved= (boolean)session.getAttribute("reserved");
	    	}
	    	if(reserved==true) {
	    		
	    		/*ArrayList<Chambre> attribute2 = (ArrayList<Chambre>)session.getAttribute( "liste_types" );
	    		List<Chambre> liste_types =attribute2;
	    		for(int i=0;i<liste_types.size();i++) {
	    			d=0;
	    			System.out.println("voila l indice de parametre "+request.getParameter(Integer.toString(i+1)));
	    			k=Integer.parseInt(request.getParameter(Integer.toString(i+1)));
	    			System.out.println("k ="+k);}*/
	    		response.sendRedirect( request.getContextPath() +  "/reservation");
	    	}
	    	else {
	    	response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
	    	this.getServletContext().getRequestDispatcher( "/innerpages/acceuilUser.jsp" ).forward( request, response );
	    	session.removeAttribute("message");
        	
        	
        	
        	//Client c =(Client)session.getAttribute("session_user");
	    	
	    		}
	    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
