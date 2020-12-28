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
import sdzee.com.beans.Client;

/**
 * Servlet implementation class gestion_clientslocal
 */
@WebServlet("/gestion_clientslocal")
public class gestion_clientslocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestion_clientslocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if ( session.getAttribute("session_local")==null) {
			System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
         	response.sendRedirect( request.getContextPath() +"/Loginusers");
        } else {
		Database d=new Database();
		ArrayList<Client> clients=d.getAllClients();
		request.setAttribute("clients",clients);
		response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");
			this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_clientslocal.jsp").forward(request, response);
			session.removeAttribute("messagelo");
        }
	
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database d=new Database();
		System.out.println(request.getParameter("type"));
		if(request.getParameter("type").equals("change")) {
			d.changeuser(request);
		}
		if(request.getParameter("type").equals("add")) {
			d.Inscription(request);
		}
		if(request.getParameter("type").equals("remove")) {
			d.removeClient(request.getParameter("cin"));
		}
		response.sendRedirect( request.getContextPath() +  "/gestion_clientslocal");
	}

}



