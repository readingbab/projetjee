package sdzee.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.form.loginForm;

/**
 * Servlet implementation class inscriptionservlet
 */
@WebServlet("/inscriptionservlet")
public class inscriptionservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public inscriptionservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/innerpages/usercreate.jsp" ).forward( request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginForm l=new loginForm();
		int t=l.loginClient(request );
		System.out.println(t);
		if(l.getErreurs().isEmpty()) {
			HttpSession session = request.getSession();
	    	boolean reserved;
	    	if(session.getAttribute("reserved")==null){
	    		reserved=false;
	    	}
	    	else {
	    		reserved= (boolean)session.getAttribute("reserved");
	    	}
			if(reserved==true) {
	    		response.sendRedirect( request.getContextPath() +  "/loginservlet");
	    	}
			else {
				
			
			this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
			}
			}
		else {
			request.setAttribute("error",l.getErreurs());
			doGet(request,response);
		}
	}
}
