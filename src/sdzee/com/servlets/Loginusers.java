package sdzee.com.servlets;

import java.io.IOException;
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
import sdzee.com.beans.Receptionniste;

/**
 * Servlet implementation class Loginusers
 */
@WebServlet("/Loginusers")
public class Loginusers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginusers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("session_global")!=null || session.getAttribute("session_local")!=null || session.getAttribute("session_receptionniste")!=null ){
			if(session.getAttribute("session_global")!=null) {
			response.sendRedirect( request.getContextPath() +  "/Accueille_global");}
			else {
				if(session.getAttribute("session_local")!=null) {
					response.sendRedirect( request.getContextPath() +  "/Accueille_local");
				}else {
					response.sendRedirect( request.getContextPath() +  "/Accueille_receptionniste");
				}
			}
			
			
		}
		else {
		response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
		this.getServletContext().getRequestDispatcher( "/WEB-INF/loginusers.jsp" ).forward( request, response );
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ce je fais ce int a pour que la servlet faire la differance entre qui a deconnecter et qui a entrer un mot de passe fausse
		int a=0;
		if(request.getParameter("deconnecterglobal")!=null) {
			if(request.getParameter("deconnecterglobal").equals("deconnecterglobal")){
			HttpSession session = request.getSession();
			session.removeAttribute("session_global");
			a=1;
		} }
		if(request.getParameter("deconnecterlocal")!=null) {
			if(request.getParameter("deconnecterlocal").equals("deconnecterlocal")){
			HttpSession session = request.getSession();
			session.removeAttribute("session_local");
			a=1;
		} }
		if(request.getParameter("deconnecterrecpt")!=null) {
			if(request.getParameter("deconnecterrecpt").equals("deconnecterrecpt")){
			HttpSession session = request.getSession();
			session.removeAttribute("session_receptionniste");
			a=1;
		} }
		Database d=new Database();
		 Receptionniste r=null;
		 Admin_local l=null;
		 Admin_global g=null;
			r=d.Testreceptionniste(request);
			//g=d.TestAdmin_global(request);
			//l=d.TestAdmin_local(request);
			if (r== null ) {
							l=d.TestAdmin_local(request);
					if(l==null) {
									g=d.TestAdmin_global(request);
									if(g==null) {
										if(a==0) {
										request.setAttribute("error","echec d'athentification,verifier votre email et mot de passe");
										}
										doGet(request,response);	
									}
									else {
										System.out.println(r);
								    	HttpSession session = request.getSession();
								    	session.setAttribute( "session_global",g);
								    	response.sendRedirect( request.getContextPath() +  "/Accueille_global");
								    	//this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilAdmin_global.jsp" ).forward( request, response );
								    	
										
									}
									
									
					}else {
						
						System.out.println(r);
				    	HttpSession session = request.getSession();
				    	session.setAttribute( "session_local",l);
				    	response.sendRedirect( request.getContextPath() +  "/Accueille_local");
				    	//this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilAdmin_local.jsp" ).forward( request, response );
				    	
						
					}
		           
				
		    } else {
		    	System.out.println(r);
		    	HttpSession session = request.getSession();
		    	session.setAttribute( "session_receptionniste",r);
		    	response.sendRedirect( request.getContextPath() +  "/Accueille_receptionniste");
		    	//this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilreceptionniste.jsp" ).forward( request, response );
		    	
		    	}
		    }
}


