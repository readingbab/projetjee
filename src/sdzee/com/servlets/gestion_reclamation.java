package sdzee.com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.bdd.*;
import sdzee.com.beans.*;
/**
 * Servlet implementation class gestion_reclamation
 */
@WebServlet("/gestion_reclamation")
public class gestion_reclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestion_reclamation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database d=new Database();
		HttpSession session = request.getSession();
		Admin_local a=(Admin_local)session.getAttribute("session_local");
		int id_hotel=d.getId_hotelDb(a.getVille_hotel(),a.getNom_hotel());
		ArrayList<Reclamation> reclamations=d.getReclamation(id_hotel);
		request.setAttribute("reclamations",reclamations);
		this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_reclamation.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
