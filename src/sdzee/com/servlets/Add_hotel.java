package sdzee.com.servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sdzee.com.bdd.*;
import sdzee.com.beans.*;
/**
 * Servlet implementation class Add_hotel
 */
@WebServlet("/Add_hotel")
public class Add_hotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_hotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/add_hotel.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		Database d=new Database();
		Hotel hotel=new Hotel(0, request.getParameter("nom_hotel"),request.getParameter("ville_hotel"),request.getParameter("addresse_hotel"),0,Integer.parseInt(request.getParameter("etoile_hotel")));
		int id_hotel=d.ajouter_HOTEL(hotel);
		String url="/gerer_hotel?id_hotel="+String.valueOf(id_hotel);
		response.sendRedirect( request.getContextPath() +url);
		
	}

}
