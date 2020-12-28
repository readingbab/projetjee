package sdzee.com.servlets;

import java.io.IOException;
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
/**
 * Servlet implementation class Modifier_employe
 */
@WebServlet("/Modifier_employe")
public class Modifier_employe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_employe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

    	if ( session.getAttribute("session_local") == null ) {
    			
	         	response.sendRedirect( request.getContextPath() +"/Loginusers");
	        } else {
	Database d=new Database();
	HashMap<String,List<String>> VilleHotel= d.ShowHotelVille();
	request.setAttribute("VilleHotel", VilleHotel);
	Admin_local l =(Admin_local) session.getAttribute( "session_local" );
	ArrayList<Receptionniste> receptionniste=d.getAllReceptionniste(d.getId_hotelDb(l.getVille_hotel(),l.getNom_hotel()));
	request.setAttribute("receptionniste",receptionniste);
	response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
	this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_employe1.jsp").forward(request, response);
	        }		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		System.out.println(type);
		if(type.equals("change")) {
			System.out.println("hihi");
			System.out.println(request.getParameter("cin")+"123");
			String cin=request.getParameter("cin");
			String prenom=request.getParameter("prenom");
			String nom=request.getParameter("nom");
			String telephone=request.getParameter("phone");
			String email=request.getParameter("email");
			String addresse=request.getParameter("addresse");
			String mot_passe=request.getParameter("mdp");
			String ville_hotel=request.getParameter("ville");
			String nom_hotel=request.getParameter("hotel");
			Database d=new Database();
			d.changeReceptionniste(cin, prenom, nom, telephone, email, addresse, mot_passe, ville_hotel, nom_hotel);
		}
		if(type.equals("add")) {
			HttpSession session = request.getSession();
			Admin_local r =(Admin_local)session.getAttribute("session_local");
			System.out.println(r.getVille_hotel());
			Receptionniste receptionniste=new Receptionniste();
			receptionniste.setCin(request.getParameter("cin"));
			receptionniste.setNom(request.getParameter("nom"));
			receptionniste.setPrenom(request.getParameter("prenom"));
			receptionniste.setTelephone(request.getParameter("telephone"));
			receptionniste.setEmail(request.getParameter("email"));
			receptionniste.setAddresse(request.getParameter("addresse"));
			receptionniste.setMot_passe(request.getParameter("mot_passe"));
			receptionniste.setVille_hotel(r.getVille_hotel());
			receptionniste.setNom_hotel(r.getNom_hotel());
			Database add=new Database();
			add.ajouter_EMPLOYER(receptionniste);
			String str="l'ajoute de l'employer est reusite !!!!";
		}
		if(type.equals("remove")) {
			HttpSession session = request.getSession();
			Database d=new Database();
		    d.supprimer_EMPLOYER(request.getParameter("cin"));
			
			}
		response.sendRedirect( request.getContextPath() +"/Modifier_employe");
		
	}
	

}
