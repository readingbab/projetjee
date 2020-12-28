package sdzee.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.beans.*;
import sdzee.com.bdd.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class gestion_clients
 */
@WebServlet("/gestion_clients")
public class gestion_clients extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if ( session.getAttribute("session_receptionniste")==null) {
			System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
         	response.sendRedirect( request.getContextPath() +"/Loginusers");
        } else {
		Database d=new Database();
		ArrayList<Client> clients=d.getAllClients();
		request.setAttribute("clients",clients);
		response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
			this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_clients.jsp").forward(request, response);
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
		response.sendRedirect( request.getContextPath() +  "/gestion_clients");
	}

}
