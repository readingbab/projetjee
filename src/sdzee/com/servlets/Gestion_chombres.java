package sdzee.com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.bdd.Database;
import sdzee.com.beans.Admin_local;
import sdzee.com.beans.Chambre;

/**
 * Servlet implementation class Gestion_chombres
 */
@WebServlet("/Gestion_chombres")
public class Gestion_chombres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_chombres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 if ( session.getAttribute("session_local") == null ) {
			
	         	response.sendRedirect( request.getContextPath() +  "/loginusers");
	        } else {
	        	this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_chombres.jsp").forward(request, response);	
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin_local l=(Admin_local) session.getAttribute("session_local"); 
		if(request.getParameter("modifier").equals("modifier")) {
			Database add=new Database();
			Chambre chambre=new Chambre();
			chambre.setNumero_chambre(Integer.parseInt(request.getParameter("numero_chambre")));
			chambre.setType_chambre(request.getParameter("type_chambre"));
			chambre.setNombre_place(Integer.parseInt(request.getParameter("nombre_place")));
			chambre.setPrix_jour(Double.parseDouble(request.getParameter("prix_jour")));
			chambre.setId_hotel(add.getId_hotelDb(l.getVille_hotel(),l.getNom_hotel()));
			System.out.println("cin ------------<>>>"+request.getParameter("cin"));
			add.modifier_CHAMBRE(chambre);
			doGet(request, response);
			
		}else {
			if(request.getParameter("supprimer").equals("supprimer")) {
				Database add=new Database();
				add.supprimer_CHAMBRE(add.getId_hotelDb(l.getVille_hotel(),l.getNom_hotel()),Integer.parseInt(request.getParameter("numero_chambre")));
				String str="l'operation de suppresion reusite !!!!";
				request.setAttribute("str",str);
				doGet(request, response);
			}else {
				if(request.getParameter("ajouter").equals("ajouter")) {
					Chambre chambre=new Chambre();
					Database add=new Database();
					chambre.setId_hotel(add.getId_hotelDb(l.getVille_hotel(), l.getNom_hotel()));
					chambre.setNombre_place(Integer.parseInt(request.getParameter("nombre_place")));
					chambre.setNumero_chambre(Integer.parseInt(request.getParameter("numero_chambre")));
					chambre.setPrix_jour(Double.parseDouble(request.getParameter("prix_jour")));
					chambre.setType_chambre(request.getParameter("type_chambre"));
					int i=add.ajouter_CHAMBRE(chambre);
					String str="l'ajoute de l'employer est reusite !!!!";
					request.setAttribute("str",str);
					doGet(request, response);
				}
			}
		}
		
	}

}
