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

import sdzee.com.beans.*;
import sdzee.com.bdd.*;
/**
 * Servlet implementation class Modifier_chambre
 */
@WebServlet("/Modifier_chambre")
public class Modifier_chambre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_chambre() {
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
    	//HashMap<String,List<String>> VilleHotel= d.ShowHotelVille();
    	//request.setAttribute("VilleHotel", VilleHotel);
		Admin_local r =(Admin_local)session.getAttribute("session_local");
    	ArrayList<Chambre> receptionniste=d.getAllchambres(d.getId_hotelDb(r.getVille_hotel(), r.getNom_hotel()));
    	request.setAttribute("receptionniste",receptionniste);
    	int max=d.maxnumero_chambre(d.getId_hotelDb(r.getVille_hotel(), r.getNom_hotel()))+1;
    	request.setAttribute("max",max);
    	response.setHeader("Cache-Control","no-cache , no-store ,must-revalidate");
    		this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_chambre1.jsp").forward(request, response);
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
			int id_hotel=Integer.parseInt(request.getParameter("id_hotel"));
			int numero_chambre=Integer.parseInt(request.getParameter("numero_chambre"));
			String type_chambre=request.getParameter("type_chambre");
			Double prix_jour=Double.parseDouble(request.getParameter("prix_jour"));
			int nombre_place=Integer.parseInt(request.getParameter("nombre_place"));
			Database d=new Database();
			d.changeChambre(id_hotel, numero_chambre, type_chambre, nombre_place, prix_jour);
		}
		if(type.contentEquals("add")) {
			HttpSession session = request.getSession();
			Admin_local r =(Admin_local)session.getAttribute("session_local");
			System.out.println(r.getVille_hotel());
			Chambre chambre=new Chambre();
			Database add=new Database();
			chambre.setId_hotel(add.getId_hotelDb(r.getVille_hotel(), r.getNom_hotel()));
			chambre.setNombre_place(Integer.parseInt(request.getParameter("nombre_place")));
			int a=(Integer.parseInt(request.getParameter("numero_chambre1")));
			int b=(Integer.parseInt(request.getParameter("numero_chambre2")));
			chambre.setPrix_jour(Double.parseDouble(request.getParameter("prix_jour")));
			chambre.setType_chambre(request.getParameter("type_chambre"));
			int i=add.ajouter_CHAMBRE(chambre,a,b);
			String str="l'ajoute de l'employer est reusite !!!!";
		}
		if(type.contentEquals("remove")) {
			HttpSession session = request.getSession();
			Admin_local r =(Admin_local)session.getAttribute("session_local");
			System.out.println(r.getVille_hotel());
			Chambre chambre=new Chambre();
			Database add=new Database();
			add.supprimer_CHAMBRE(add.getId_hotelDb(r.getVille_hotel(), r.getNom_hotel()),Integer.parseInt(request.getParameter("numero_chambre")));
		}
		doGet(request,response);
		
	}
	/*
	
	dddddddddddddddddddddddd
	
	Chambre chambre=new Chambre();
	Database add=new Database();
	chambre=add.info_CHAMBRE(add.getId_hotelDb(request.getParameter("ville_hotel"), request.getParameter("nom_hotel")),Integer.parseUnsignedInt(request.getParameter("numero_chambre")));
	request.setAttribute("chambre",chambre);
	this.getServletContext().getRequestDispatcher("/WEB-INF/modifier_chambre2.jsp").forward(request, response);*/
	//dddddddddddddddddddddddddddddd
//}

}
