package sdzee.com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.bdd.*;
import sdzee.com.beans.*;
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("session_user")!=null){
			Client c=(Client)session.getAttribute("session_user");
			response.sendRedirect( request.getContextPath() +  "/Accueille_client");
			//session.removeAttribute("message"); 09012020 modified
			
		}
		else {
			response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
			this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=0;
		if(request.getParameter("deconnecteruser")!=null) {
			if(request.getParameter("deconnecteruser").equals("deconnecteruser")){
			HttpSession session = request.getSession();
			session.removeAttribute("session_user");
			a=1;
		} }  
		
		
		Database d=new Database();
				Client c=null;
				c=d.executerTests(request);
				if (c== null ) {
					if(a==0) {
						request.setAttribute("error","echec d'athentification,verifier votre email et mot de passe");
						}	
					doGet(request,response);
			    } else {
			    	System.out.println(c);
			    	HttpSession session = request.getSession();
			    	session.setAttribute( "session_user",c);
			    	/*boolean reserved;
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
			    		/*response.sendRedirect( request.getContextPath() +  "/reservation");
			    	}
			    	else {
			    	this.getServletContext().getRequestDispatcher( "/innerpages/acceuilUser.jsp" ).forward( request, response );
			    	session.removeAttribute("message");*/
			    	response.sendRedirect( request.getContextPath() +  "/Accueille_client");

			    	}
			    }
	}

