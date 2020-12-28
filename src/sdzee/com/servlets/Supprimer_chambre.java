package sdzee.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sdzee.com.bdd.*;
/**
 * Servlet implementation class Supprimer_chambre
 */
@WebServlet("/Supprimer_chambre")
public class Supprimer_chambre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimer_chambre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimer_chambre.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database add=new Database();
		add.supprimer_CHAMBRE(add.getId_hotelDb(request.getParameter("ville_hotel"), request.getParameter("nom_hotel")),Integer.parseInt(request.getParameter("numero_chambre")));
		String str="l'operation de suppresion reusite !!!!";
		request.setAttribute("str",str);
		this.getServletContext().getRequestDispatcher("/WEB-INF/supprimer_chambre.jsp").forward(request, response);
	}

}
