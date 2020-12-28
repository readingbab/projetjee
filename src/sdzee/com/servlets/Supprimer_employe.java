package sdzee.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sdzee.com.bdd.*;
/**
 * Servlet implementation class Supprimer_employe
 */
@WebServlet("/Supprimer_employe")
public class Supprimer_employe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimer_employe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimer_employe.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database add=new Database();
		add.supprimer_EMPLOYER(request.getParameter("cin"));
		String str="l'operation de suppresion reusite !!!!";
		request.setAttribute("str",str);
		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimer_employe.jsp").forward(request, response);
			
	}

}
