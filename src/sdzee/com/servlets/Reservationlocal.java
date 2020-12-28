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
import sdzee.com.beans.Chambre;

/**
 * Servlet implementation class Reservationlocal
 */
@WebServlet("/Reservationlocal")
public class Reservationlocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservationlocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
	        	
	        	//////////////////////////////////////////////////////////////////////////////////////
	        	Database addreservation=new Database();
	    		sdzee.com.beans.Reservation reservation=(sdzee.com.beans.Reservation)session.getAttribute("reservation");
	    		ArrayList<Chambre> attribute1 = (ArrayList<Chambre>)session.getAttribute( "liste_chambres" );
	    		List<Chambre> liste_chambres =attribute1;
	    		ArrayList<Chambre> attribute2 = (ArrayList<Chambre>)session.getAttribute( "liste_types" );
	    		List<Chambre> liste_types =attribute2;
	    		System.out.println("liste types  resultat :"+liste_types);
	    		System.out.println("liste chambres resulatat  :"+liste_chambres);
	    		reservation.setValidation(request.getParameter("validation"));
	    		reservation.setId_hotel(liste_types.get(0).getId_hotel());
	    		System.out.println("id   "+reservation.getId_hotel() +" date debut "+ reservation.getDate_debut() +" validation"+reservation.getValidation());
	    		HashMap<Integer, String[]> id_types = new HashMap<Integer, String[]>();
	    		//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	    		//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	    		//on peut avoir plusieur reservation a la foit donc il faut une liste des reservation;
	    		id_types=(HashMap<Integer, String[]>)session.getAttribute("id_types");
	    		int k=0;
	    		int d=0;
	    		System.out.println(liste_types.size());
	    		System.out.println("our map"+id_types);
	    		int [] l=new int[liste_types.size()];
	    		
	    		for(int i=0;i<liste_types.size();i++) {
	    			
	    			System.out.println("voila l indice de parametre "+request.getParameter(Integer.toString(i+1)));
	    			l[i]=Integer.parseInt(request.getParameter(Integer.toString(i+1)));
	    			}
	    		
	    		for(int i=0;i<liste_types.size();i++) {
	    			d=0;
	    			
	    			k=l[i];
	    			System.out.println("k ="+k);
	    			
	    			
	    				//if(liste_chambres.get(d).getType_chambre().equals(id_types.get(i)[0]) && liste_chambres.get(d).getNombre_place()==Integer.parseInt(id_types.get(i)[1]) && liste_chambres.get(d).getPrix_jour()==Double.parseDouble((id_types.get(i)[2]))) {
	    				//if(liste_chambres.get(j).getType_chambre().equals(id_types.get(i)[0]) && liste_chambres.get(j).getNombre_place()==Integer.parseInt(id_types.get(i)[1]) && liste_chambres.get(j).getPrix_jour()==Double.parseDouble((id_types.get(i)[2]))) {	
	    				//System.out.println("ouiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	    					//reservation.setNumero_chambre(liste_chambres.get(d).getNumero_chambre());
	    					//int b=addreservation.ajouter_reservation(reservation);
	    					//break;
	    				//	}
	    				
	    			//}
	    				
	    			while(k>0) {
	    				System.out.println("k ="+k);
	    				
	    				System.out.println("id_type ="+id_types.get(i)[0]);
	    				if(liste_chambres.get(d).getType_chambre().equals(liste_types.get(i).getType_chambre())) {
	    					reservation.setNumero_chambre(liste_chambres.get(d).getNumero_chambre());
	    					System.out.println("###############:::"+liste_chambres.get(d).getNumero_chambre());
	    					System.out.println("**************:::"+reservation.getNumero_chambre());
	    					
	    					String message=addreservation.ajouter_reservation(reservation);
	    					session.setAttribute("messagelo",message);
	    					k=k-1;
	    					
	    				}
	    				d++;
	    				
	    				
	    			}
	    			
	    		}
	    		session.removeAttribute("reservation");
	    		session.removeAttribute("reserved");
				response.sendRedirect( request.getContextPath() +  "/gestion_clientslocal");	}
	        
	}

