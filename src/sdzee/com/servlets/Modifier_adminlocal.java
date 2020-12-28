package sdzee.com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdzee.com.bdd.Database;
import sdzee.com.beans.Admin_global;
import sdzee.com.beans.Admin_local;
import sdzee.com.beans.Receptionniste;

/**
 * Servlet implementation class Modifier_adminlocal
 */
@WebServlet("/Modifier_adminlocal")
public class Modifier_adminlocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_adminlocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		if ( session.getAttribute("session_global") == null ) {
			
	         	response.sendRedirect( request.getContextPath() +"/Loginusers");
	        } else {
	    	Admin_global r =(Admin_global)session.getAttribute("session_global");
	    	Database d=new Database();
	    	HashMap<String,List<String>> VilleHotel= d.ShowHotelVille();
	    	request.setAttribute("VilleHotel", VilleHotel);
	    	ArrayList<Admin_local> adminL=d.getAllAdminLocal();
	    	request.setAttribute("adminL",adminL);
	    	response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");	
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_Admin_local.jsp").forward(request, response);
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
    			d.changeAdmiLocal(cin, prenom, nom, telephone, email, addresse, mot_passe, ville_hotel, nom_hotel);
    		}if(type.equals("add")) {
    			HttpSession session = request.getSession();
    			Admin_local admin_local=new Admin_local();
    			admin_local.setCin(request.getParameter("cin"));
    			admin_local.setNom(request.getParameter("nom_admin"));
    			admin_local.setPrenom(request.getParameter("prenom"));
    			admin_local.setTelephone(request.getParameter("telephone"));
    			admin_local.setEmail(request.getParameter("email"));
    			admin_local.setAddresse(request.getParameter("addresse"));
    			admin_local.setMot_passe(request.getParameter("mot_passe"));
    			System.out.println("ffffffffffffffr<<<<<<<<<<<<<"+request.getParameter("ville"));
    			admin_local.setVille_hotel(request.getParameter("ville"));
    			admin_local.setNom_hotel(request.getParameter("nom"));
    			Database add=new Database();
    			int i=add.ajouter_ADMIN_LOCAL(admin_local);
    			String str="l'ajoute de l'employer est reusite !!!!";
    		}if(type.contentEquals("remove")) {
    			Database d=new Database();
    			d.supprimer_ADMINLOCAL(request.getParameter("cin"));
    			
    			}
    		response.sendRedirect( request.getContextPath() +"/Modifier_adminlocal");
    		
    	}

}

