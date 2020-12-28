

package sdzee.com.bdd;
import java.sql.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;
import javax.swing.text.DateFormatter;
import org.apache.taglibs.standard.tag.common.fmt.FormatDateSupport;

import com.sun.glass.ui.Pixels.Format;
import sun.text.resources.cldr.FormatData;
import sun.text.resources.cldr.xog.FormatData_xog;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdzee.com.beans.*;
import javax.servlet.http.HttpServletRequest;
import sdzee.com.beans.*;
public class Database {
	private Connection connexion;
	 public static java.util.Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	
	 public List<Chambre> recupererchambres(String ville,String nom,Date date_debut,Date date_fin )  {
			List<Chambre> chambres =new ArrayList<Chambre>();
			
			
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("select numero_chambre,nombre_place,type_chambre,c.id_hotel ,prix_jour from chambre c join hotel h on c.id_hotel=h.id_hotel where h.nom_hotel=? and h.ville=? and c.numero_chambre not in (select numero_chambre from reservation r WHERE id_hotel=h.id_hotel and not ((? < r.DATE_DEBUT and ? <= r.DATE_DEBUT) or (r.DATE_FIN <= ? and r.DATE_FIN < ? ))) ;");
				preparedStatement.setString(1,nom);
				preparedStatement.setString(2,ville);
				//Date date_debut = Calendar.getInstance (). GetTime ();  
				DateFormat dateFormat =  new  SimpleDateFormat ( "yyyy-MM-dd" );  
				String datedebut = dateFormat.format (date_debut);
				String datefin = dateFormat.format (date_fin);
				
				System.out.println("voila la date de debut : "+date_debut);
		        preparedStatement.setString(3,datedebut);
				preparedStatement.setString(4,datefin);
				preparedStatement.setString(5,datedebut);
				preparedStatement.setString(6,datefin);
				System.out.println(preparedStatement);
				resultat=preparedStatement.executeQuery();
				System.out.println("first");
				while(resultat.next()) {
					System.out.println("seconde in while");
					Chambre chambre =new Chambre(resultat.getInt("numero_chambre"),resultat.getInt("nombre_place"),resultat.getString("type_chambre"),resultat.getDouble("prix_jour") ,resultat.getInt("id_hotel"));
					System.out.println("BBBBBBBBBBBBBBBBB");
					chambres.add(chambre);
				}
				
				
			}catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return chambres;
			
		}
		
		//##############################################""
		public List<Chambre> nombrechambres(String ville,String nom,Date date_debut,Date date_fin )  {
			List<Chambre> chambres =new ArrayList<Chambre>();
			
			
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("select count(*) nombre_chambres,nombre_place,type_chambre,c.id_hotel ,prix_jour from chambre c join hotel h on c.id_hotel=h.id_hotel where h.nom_hotel=? and h.ville=? and c.numero_chambre not in (select numero_chambre from reservation r WHERE id_hotel=h.id_hotel and not ((? < r.DATE_DEBUT and ? <= r.DATE_DEBUT) or (r.DATE_FIN <= ? and r.DATE_FIN < ? ))) group by c.TYPE_CHAMBRE,c.NOMBRE_PLACE;");
				preparedStatement.setString(1,nom);
				preparedStatement.setString(2,ville);
				//Date date_debut = Calendar.getInstance (). GetTime ();  
				DateFormat dateFormat =  new  SimpleDateFormat ( "yyyy-MM-dd" );  
				String datedebut = dateFormat.format (date_debut);
				String datefin = dateFormat.format (date_fin);
				
				System.out.println("voila la date de debut : "+date_debut);
		        preparedStatement.setString(3,datedebut);
				preparedStatement.setString(4,datefin);
				preparedStatement.setString(5,datedebut);
				preparedStatement.setString(6,datefin);
				System.out.println(preparedStatement);
				resultat=preparedStatement.executeQuery();
				System.out.println("first");
				while(resultat.next()) {
					System.out.println("seconde in while");
					Chambre chambre =new Chambre(resultat.getInt("nombre_chambres"),resultat.getInt("nombre_place"),resultat.getString("type_chambre"),resultat.getDouble("prix_jour") ,resultat.getInt("id_hotel"));
					System.out.println("BBBBBBBBBBBBBBBBB");
					chambres.add(chambre);
				}
				
				
			}catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return chambres;
			
		}
	 
	private void loadDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	try {
				
				connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/S4?useTimezone=true&serverTimezone=UTC","root","root");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	    public Client executerTests( HttpServletRequest request ) {
	    	String mdp=request.getParameter("password");
	    	Connection connexion=null ;
	    	    ResultSet resultat = null;
	    	    Client c=null;
	    	    try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		        	
		        }

		        try {
		            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	    	try {
	    		PreparedStatement preparedStatement = connexion.prepareStatement( "SELECT * FROM client WHERE email=?;" );
	    		preparedStatement.setString( 1,request.getParameter("email"));
	    		resultat = preparedStatement.executeQuery();
	    		System.out.println("************=>>"+preparedStatement);
	    	    while ( resultat.next() ) { 
	    	    	c=new Client();
	    	    	c.setCin(resultat.getString( "CIN" ));
	    	    	c.setNom(resultat.getString( "NOM" ));
	    	    	c.setPrenom(resultat.getString( "PRENOM" ));
	    	    	c.setPhone(resultat.getString( "TELEPHONE" ));
	    	    	c.setPassword(resultat.getString( "MOT_PASSE" ));
	    	    	c.setEmail(resultat.getString( "EMAIL" ));
	    	    	c.setAddresse(resultat.getString("ADDRESSE"));
	    	    	
	    	    }
	    	} catch ( SQLException e ) {
	    	   e.printStackTrace();
	    	} finally {
	    	    if ( connexion != null )
	    	        try {
	    	            /* Fermeture de la connexion */
	    	            connexion.close();
	    	        } catch ( SQLException ignore ) {
	    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
	    	        }
	    	}
	    	if(c!=null) {
	    	if(!c.getPassword().equals(mdp)){
	    		c=null;
	    	}
	    	}

	        return c;
	    
}
	    public int Inscription(HttpServletRequest request) {
	    	int statut=0;
	    	Connection connexion=null ;
	    	    ResultSet resultat = null;
	    	    try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		        	
		        }

		        try {
		            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	    	try {
	    		PreparedStatement preparedStatement = connexion.prepareStatement( "INSERT INTO client VALUES(?, ?, ?, ?,?,?,?);" );
	    		preparedStatement.setString( 1, request.getParameter("cin") );
	    		preparedStatement.setString( 2, request.getParameter("nom"));
	    		preparedStatement.setString( 3, request.getParameter("prenom"));
	    		preparedStatement.setString( 4, request.getParameter("phone"));
	    		preparedStatement.setString( 5, request.getParameter("email"));
	    		preparedStatement.setString( 6, request.getParameter("add"));
	    		preparedStatement.setString( 7, request.getParameter("mdp"));
	    		preparedStatement.executeUpdate();
	    		statut =1; 
	    		
	    	} catch ( SQLException e ) {
		    	   e.printStackTrace();
		    	} finally {
		    	    if ( connexion != null )
		    	        try {
		    	            /* Fermeture de la connexion */
		    	            connexion.close();
		    	        } catch ( SQLException ignore ) {
		    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		    	        }
		    	}
	    	return statut;
	    	
	    }
	    public Client changeuser(HttpServletRequest request) {
	    	Connection connexion=null ;
	    	    ResultSet resultat;
	    	    Client c=null;
	    	    try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		        	
		        }

		        try {
		            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	    	try {

	    		PreparedStatement preparedStatement = connexion.prepareStatement( "UPDATE client SET nom=?,prenom=?,telephone=?,email=?,addresse=?,mot_passe=? WHERE cin=?" );
	    		preparedStatement.setString( 7, request.getParameter("cin") );
	    		System.out.println(request.getParameter("cin") );
	    		preparedStatement.setString( 1, request.getParameter("nom"));
	    		preparedStatement.setString( 2, request.getParameter("prenom"));
	    		preparedStatement.setString( 3, request.getParameter("phone"));
	    		preparedStatement.setString( 4, request.getParameter("email"));
	    		preparedStatement.setString( 5, request.getParameter("addr"));
	    		preparedStatement.setString( 6, request.getParameter("mdp"));
	    		preparedStatement.executeUpdate();
	    		 PreparedStatement preparedStatement1 = connexion.prepareStatement( "SELECT * FROM client WHERE email=?;" );
		    		preparedStatement1.setString( 1,request.getParameter("email"));
		    		resultat = preparedStatement1.executeQuery();
		    		System.out.println("************=>>"+preparedStatement);
		    	    while ( resultat.next() ) { 
		    	    	c=new Client();
		    	    	c.setCin(resultat.getString( "CIN" ));
		    	    	c.setNom(resultat.getString( "NOM" ));
		    	    	c.setPrenom(resultat.getString( "PRENOM" ));
		    	    	c.setPhone(resultat.getString( "TELEPHONE" ));
		    	    	c.setPassword(resultat.getString( "MOT_PASSE" ));
		    	    	c.setEmail(resultat.getString( "EMAIL" ));
		    	    	c.setAddresse(resultat.getString("ADDRESSE"));
		    	    	
		    	    }
	    	} catch ( SQLException e ) {
	    	   e.printStackTrace();
	    	} finally {
	    	    if ( connexion != null )
	    	        try {
	    	            connexion.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	}
	    	return c;
	    	}
	    public  List<ReservationHotel> ShowReservation(HttpServletRequest request, String cin) {
	    	Connection connexion=null ;
	    	String type=(String) request.getParameter("type");
	    	    Reservation reservation= new  Reservation(-1,parseDate("2014-02-14"),parseDate("2014-02-14"),"false");
	    	    ReservationHotel reservationhotel=new ReservationHotel(reservation,"");
	    	    List<ReservationHotel> reservations =new ArrayList<ReservationHotel>();
	    	    try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		        	
		        }

		        try {
		            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	    	try {

	    		PreparedStatement preparedStatement = connexion.prepareStatement( "SELECT  ID_RESERVATION,DATE_DEBUT, DATE_FIN,reservation.ID_HOTEL,NUMERO_CHAMBRE,Nom_HOTEL FROM reservation JOIN hotel on reservation.ID_HOTEL=hotel.ID_HOTEL WHERE  VALIDATION=?  AND CIN_CLIENT=?" );
	    		preparedStatement.setString( 1,type);
	    		preparedStatement.setString( 2,cin);
	    		ResultSet resultat= preparedStatement.executeQuery();
	    	    while ( resultat.next() ) {
	    	    	reservation= new  Reservation(-1,parseDate("2014-02-14"),parseDate("2014-02-14"),"false");
	    	    	reservation.setId_reservation(resultat.getInt( "ID_RESERVATION" ));
	    	    	reservation.setDate_debut(resultat.getDate( "DATE_DEBUT" ));
	    	    	reservation.setDate_fin(resultat.getDate( "DATE_FIN" ));
	    	    	reservation.setId_hotel(resultat.getInt( "ID_HOTEL" ));
	    	    	reservation.setNumero_chambre(resultat.getInt( "NUMERO_CHAMBRE" ));
	    	    	reservationhotel=new ReservationHotel(reservation,resultat.getString( "Nom_HOTEL"));
	    	    	reservations.add(reservationhotel);
	    	    }
	    	} catch ( SQLException e ) {
	    	   e.printStackTrace();
	    	} finally {
	    	    if ( connexion != null )
	    	        try {
	    	            connexion.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	}
	    	return reservations;
	    	}
	    public int changereservation(HttpServletRequest request, String validation) {
	    	Connection connexion=null ;
	    	    int resultat = 0;
	    	    try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		        	
		        }

		        try {
		            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	    	try {

	    		PreparedStatement preparedStatement = connexion.prepareStatement( "UPDATE reservation SET VALIDATION=? WHERE ID_RESERVATION=?" );
	    		preparedStatement.setString( 1,validation);
	    		preparedStatement.setString( 2, request.getParameter("reservationId"));
	    		 resultat = preparedStatement.executeUpdate();
	    	} catch ( SQLException e ) {
	    	   e.printStackTrace();
	    	} finally {
	    	    if ( connexion != null )
	    	        try {
	    	            connexion.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	}
	    	return resultat;
	    	}
	    public  HashMap<String,List<String>> ShowHotelVille() {
	    	Connection connexion=null ;
	    	HashMap<String,List<String>> VilleHotel = new HashMap<String,List<String>>();
	    	List<String> hotels=new ArrayList<String>();
	    	    try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (ClassNotFoundException e) {
		        	
		        }

		        try {
		            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	    	try {

	    		PreparedStatement preparedStatement = connexion.prepareStatement( "SELECT DISTINCT VILLE from hotel" );
	    		ResultSet resultat= preparedStatement.executeQuery();
	    		PreparedStatement preparedStatement1;
	    		ResultSet resultat1;
	    		String ville;
	    	    while ( resultat.next() ) {
	    	    	ville=new String();
	    	    	ville=resultat.getString( "Ville" );
	    	    	hotels=new ArrayList<String>();
	    	    	preparedStatement1 = connexion.prepareStatement( "SELECT Nom_HOTEL from hotel where ville=?" );
	    	    	preparedStatement1.setString(1,ville);
		    		resultat1= preparedStatement1.executeQuery();
		    		while ( resultat1.next() ) {
		    			hotels.add(resultat1.getString( "Nom_HOTEL" ));
		    		}
		    		VilleHotel.put(ville,hotels);
	    	    }
	    	} catch ( SQLException e ) {
	    	   e.printStackTrace();
	    	} finally {
	    	    if ( connexion != null )
	    	        try {
	    	            connexion.close();
	    	        } catch ( SQLException ignore ) {
	    	        }
	    	}
	    	return VilleHotel;
	    	}
	    public String ajouter_reservation(Reservation reservation) {
	    	String message;
			System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
				DateFormat dateFormat =  new  SimpleDateFormat ( "yyyy-MM-dd" );  
				System.out.println("date fin "+reservation.getDate_fin());
				System.out.println("date debut "+reservation.getDate_debut());
				String datefin = dateFormat.format (reservation.getDate_fin());
				String datedebut = dateFormat.format (reservation.getDate_debut());
				
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("insert into reservation values(NULL,?,?,?,?,?,?);");
				preparedStatement.setString(1,datedebut);
				preparedStatement.setString(2,datefin);
				preparedStatement.setString(3,reservation.getValidation());
				preparedStatement.setString(4,reservation.getCin_client());
				//preparedStatement.setString(4,"AA111");
				preparedStatement.setInt(5,reservation.getId_hotel());
				preparedStatement.setInt(6,reservation.getNumero_chambre());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
			    message="reservation bien enregistrer";
				System.out.println(message);
			}catch (SQLException e) {
				System.out.println("probleme de reservation");
				message="probleme";
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return message;
		}
	    public int ajouter_EMPLOYER(Receptionniste receptionniste) {
			System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("insert into receptionniste values(?,?,?,?,?,?,?,?);");
				preparedStatement.setString(1,receptionniste.getCin());
				preparedStatement.setString(2,receptionniste.getNom());
				preparedStatement.setString(3,receptionniste.getPrenom());
				preparedStatement.setString(4,receptionniste.getTelephone());
				preparedStatement.setString(5,receptionniste.getEmail());
				preparedStatement.setString(6,receptionniste.getAddresse());
				preparedStatement.setString(7,receptionniste.getMot_passe());			
				preparedStatement.setInt(8,getId_hotelDb(receptionniste.getVille_hotel(),receptionniste.getNom_hotel()));
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("receptionniste  bien enregistrer");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return 1;
		}
	    public void modifier_EMPLOYER(Receptionniste receptionniste) {
			System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("update receptionniste set telephone=? , email =? , addresse=? ,mot_passe=? ,id_hotel =? where cin=? ;");
				preparedStatement.setString(6,receptionniste.getCin());
				preparedStatement.setString(1,receptionniste.getTelephone());
				preparedStatement.setString(2,receptionniste.getEmail());
				preparedStatement.setString(3,receptionniste.getAddresse());
				preparedStatement.setString(4,receptionniste.getMot_passe());			
				preparedStatement.setInt(5,getId_hotelDb(receptionniste.getVille_hotel(),receptionniste.getNom_hotel()));
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("receptionniste  bien enregistrer");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			
		}
	    public void supprimer_EMPLOYER(String cin) {
			System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("delete from receptionniste where cin=? ;");
				preparedStatement.setString(1,cin);			
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("receptionniste  bien supp");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			
		}
		
		
		public int getId_hotelDb(String ville ,String nom_hotel) {
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			int id_hotel=0;
			try {
				
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("select id_hotel from hotel where ville=? and nom_hotel=? ;");
				preparedStatement.setString(1,ville);
				preparedStatement.setString(2,nom_hotel);
				
				System.out.println(preparedStatement);
				resultat=preparedStatement.executeQuery();
				while(resultat.next()) {
					id_hotel=resultat.getInt("id_hotel");	
					System.out.print("resultat ====>"+resultat.getInt("id_hotel"));
					
				}
				
				
			}catch (SQLException e) {
				System.out.println("probleme de reservation");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();
					return id_hotel;
					
				}catch (SQLException ignore) {
					ignore.printStackTrace();
					
				}
				
				
			}
			return id_hotel;
		}
		public int ajouter_CHAMBRE(Chambre chambre) {
			System.out.println("ajouter chambre         ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("insert into chambre values(?,?,?,?,?);");
				preparedStatement.setInt(1,chambre.getNumero_chambre());
				preparedStatement.setInt(2,chambre.getNombre_place());
				preparedStatement.setString(3,chambre.getType_chambre());
				preparedStatement.setDouble(4,chambre.getPrix_jour());
				preparedStatement.setInt(5,chambre.getId_hotel());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("receptionniste  bien enregistrer");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return 1;
		}

		public void supprimer_CHAMBRE(int id_hotel,int numero_chambre) {
			System.out.println("         ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("SET FOREIGN_KEY_CHECKS = 0;delete from chambre where ID_HOTEL=? and NUMERO_CHAMBRE=? ;");
				preparedStatement.setInt(1,id_hotel);	
				preparedStatement.setInt(2,numero_chambre);	
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("chambre  bien supp");
			}catch (SQLException e) {
				System.out.println("pro de suppression ");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			
		}
		public void modifier_CHAMBRE(Chambre chambre) {
			System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("update chambre set NOMBRE_PLACE=? , TYPE_CHAMBRE =? , PRIX_JOUR=? where NUMERO_CHAMBRE=? and ID_HOTEL=? ;");
				preparedStatement.setInt(1,chambre.getNombre_place());
				preparedStatement.setString(2,chambre.getType_chambre());
				preparedStatement.setDouble(3,chambre.getPrix_jour());
				preparedStatement.setInt(4,chambre.getNumero_chambre());
				preparedStatement.setInt(5,chambre.getId_hotel());
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("receptionniste  bien enregistrer");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			
		}	
		
		public Chambre info_CHAMBRE(int id_hotel,int numero_chambre) {

			Chambre chambre=new Chambre();
			
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("select NUMERO_CHAMBRE ,NOMBRE_PLACE ,TYPE_CHAMBRE ,PRIX_JOUR ,c.ID_HOTEL from chambre c,hotel h where c.id_hotel=h.id_hotel and c.id_hotel=? and NUMERO_CHAMBRE=? ;");
				preparedStatement.setInt(1,id_hotel);
				preparedStatement.setInt(2,numero_chambre);
				System.out.println(preparedStatement);
				resultat=preparedStatement.executeQuery();
				while(resultat.next()) {
					chambre.setId_hotel(resultat.getInt("id_hotel"));
					chambre.setNumero_chambre(resultat.getInt("numero_chambre"));
					chambre.setNombre_place(resultat.getInt("nombre_place"));
					chambre.setPrix_jour(resultat.getDouble("prix_jour"));
					chambre.setType_chambre(resultat.getString("type_chambre"));
					
					
					
				}
				
				
			}catch (SQLException e) {
				System.out.println("probleme de reservation");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();
					return chambre;
					
				}catch (SQLException ignore) {
					ignore.printStackTrace();
					
				}
				
				
			}
			
			
			
			return chambre;
			
		}
		
		public int ajouter_HOTEL(Hotel hotel) {
			System.out.println("ajouter chambre         ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("insert into hotel values(null,?,?,?,?,?);");
				preparedStatement.setString(1,hotel.getNom());
				preparedStatement.setString(2,hotel.getVille());
				preparedStatement.setString(3,hotel.getAdresse());
				preparedStatement.setInt(4,hotel.getNombre_chambre());
				preparedStatement.setInt(5,hotel.getNombre_etoile());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("receptionniste  bien enregistrer");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return 1;
		}

		public Hotel info_HOTEL(int id_hotel) {
			Hotel hotel=new Hotel();
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("select * from hotel where id_hotel=? ;");
				preparedStatement.setInt(1,id_hotel);
				System.out.println(preparedStatement);
				resultat=preparedStatement.executeQuery();
				while(resultat.next()) {
					hotel.setId(resultat.getInt("id_hotel"));
					hotel.setNom(resultat.getString("nom_hotel"));
					hotel.setVille(resultat.getString("ville"));
					hotel.setAdresse(resultat.getString("adresse"));
					hotel.setNombre_chambre(resultat.getInt("nombre_chambre"));
					hotel.setNombre_chambre(resultat.getInt("nombre_etoile"));
					
				}
				
				
			}catch (SQLException e) {
				System.out.println("probleme de reservation");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();
					return hotel;
					
				}catch (SQLException ignore) {
					ignore.printStackTrace();
					
				}
				
				
			}
			
			
			
			return hotel;
			
		}

		public void modifier_HOTEL(Hotel hotel) {
			System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("update hotel set nom_hotel=? , nombre_chambre=? , nombre_etoile=?  where ID_HOTEL=? ;");
				preparedStatement.setString(1,hotel.getNom());
				preparedStatement.setInt(2,hotel.getNombre_chambre());
				preparedStatement.setInt(3,hotel.getNombre_etoile());
				preparedStatement.setInt(4,hotel.getId());
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("hotel  bien enregistrer");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			
		}	
		public void supprimer_HOTEL(int id_hotel) {
			System.out.println("         ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("delete from reservation where ID_HOTEL=?;");
				preparedStatement.setInt(1,id_hotel);
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				preparedStatement=connexion.prepareStatement("delete from chambre where ID_HOTEL=?;");
				preparedStatement.setInt(1,id_hotel);
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				preparedStatement=connexion.prepareStatement("delete from hotel where ID_HOTEL=?;");
				preparedStatement.setInt(1,id_hotel);
				System.out.println("modifier stat------------->"+preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("chambre  bien supp");
			}catch (SQLException e) {
				System.out.println("pro de suppression ");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			
		}

		public int ajouter_ADMIN_LOCAL(Admin_local admin) {
			System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
		
				statement=connexion.createStatement();
				PreparedStatement preparedStatement=connexion.prepareStatement("insert into admin_local values(?,?,?,?,?,?,?,?);");
				preparedStatement.setString(1,admin.getCin());
				preparedStatement.setString(2,admin.getNom());
				preparedStatement.setString(3,admin.getPrenom());
				preparedStatement.setString(4,admin.getTelephone());
				preparedStatement.setString(5,admin.getEmail());
				preparedStatement.setString(6,admin.getAddresse());
				preparedStatement.setString(7,admin.getMot_passe());			
				preparedStatement.setInt(8,getId_hotelDb(admin.getVille_hotel(),admin.getNom_hotel()));
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
				System.out.println("first");
				System.out.println("receptionniste  bien enregistrer");
			}catch (SQLException e) {
				System.out.println("probleme de enregistrement");
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return 1;
		}
		public ArrayList<Receptionniste> getAllReceptionniste(){
			ArrayList<Receptionniste> receptionniste = new ArrayList<Receptionniste>();
			Statement statement = null;
			ResultSet resultat =null;
			loadDatabase();
			try {
				statement=connexion.createStatement();
				resultat = statement.executeQuery( "SELECT cin,prenom,nom,telephone,email,addresse,mot_passe,nom_hotel,ville FROM receptionniste,hotel where receptionniste.id_hotel=hotel.id_hotel;" );
				Receptionniste r=null;
				while(resultat.next()) {
					r=new  Receptionniste(resultat.getString("cin"),resultat.getString("prenom"),resultat.getString("nom"),resultat.getString("telephone"),resultat.getString("email"),resultat.getString("addresse"),resultat.getString("mot_passe"),resultat.getString("ville"),resultat.getString("nom_hotel"));
					
					receptionniste.add(r);
				}
				
				
			}catch (SQLException e) {
				e.printStackTrace();
				
			}finally {
				try {
					if(resultat !=null)
						resultat.close();
					if(statement !=null)
						statement.close();
					if(connexion !=null)
						connexion.close();	
				}catch (SQLException ignore) {
					ignore.printStackTrace();
				}
				
				
			}
			return receptionniste;
		}
		
		public void changeReceptionniste(String cin, String prenom, String nom, String telephone, String email, String addresse,
				String mot_passe, String ville_hotel, String nom_hotel) {
				System.out.println(cin);
				ResultSet resultat =null;
				loadDatabase();
				try {
					PreparedStatement preparedStatement=connexion.prepareStatement("update Receptionniste set nom=? , prenom=? , telephone=?,email=?, addresse=?, mot_passe=?,id_hotel=?  where cin=? ;");
					preparedStatement.setString(1,nom);
					preparedStatement.setString(2,prenom);
					preparedStatement.setString(3,telephone);
					preparedStatement.setString(4,email);
					preparedStatement.setString(5,addresse);
					preparedStatement.setString(6,mot_passe);
					preparedStatement.setInt(7,getId_hotelDb(ville_hotel ,nom_hotel));
					preparedStatement.setString(8,cin);
					preparedStatement.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
			}
		
		
		
		 public Receptionniste Testreceptionniste( HttpServletRequest request ) {
		    	String mdp=request.getParameter("password");
		    	Connection connexion=null ;
		    	    ResultSet resultat = null;
		    	    Receptionniste rec=null;
		    	    try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			        } catch (ClassNotFoundException e) {
			        	
			        }

			        try {
			            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
		    	try {
					PreparedStatement preparedStatement=connexion.prepareStatement("select cin ,nom , prenom ,telephone ,addresse ,email ,mot_passe, ville ,nom_hotel from receptionniste r,hotel h where r.id_hotel=h.id_hotel and email=? ;");
		    		preparedStatement.setString( 1,request.getParameter("email"));
		    		resultat = preparedStatement.executeQuery();
		    		System.out.println("************=>>"+preparedStatement);
		    	    while ( resultat.next() ) { 
		    	    	System.out.println("hhhhhhhhhhhhhh"+resultat.getString("cin"));
		    	    	rec=new Receptionniste();
		    	    	rec.setCin(resultat.getString("cin"));
						rec.setNom(resultat.getString("nom"));
						rec.setPrenom(resultat.getString("prenom"));
						rec.setTelephone(resultat.getString("telephone"));
						rec.setEmail(resultat.getString("email"));
						rec.setAddresse(resultat.getString("addresse"));
						rec.setMot_passe(resultat.getString("mot_passe"));
						rec.setVille_hotel(resultat.getString("ville"));
						rec.setNom_hotel(resultat.getString("nom_hotel"));
		    	    }
		    	} catch ( SQLException e ) {
		    	   e.printStackTrace();
		    	} finally {
		    	    if ( connexion != null )
		    	        try {
		    	            /* Fermeture de la connexion */
		    	            connexion.close();
		    	        } catch ( SQLException ignore ) {
		    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		    	        }
		    	}
		    	if(rec!=null) {
		    	if(!rec.getMot_passe().equals(mdp)){
		    		rec=null;
		    	}
		    	}

		        return rec;
		    
	}
		 public Admin_local TestAdmin_local( HttpServletRequest request ) {
		    	String mdp=request.getParameter("password");
		    	Connection connexion=null ;
		    	    ResultSet resultat = null;
		    	    Admin_local rec=null;
		    	    try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			        } catch (ClassNotFoundException e) {
			        	
			        }

			        try {
			            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
		    	try {
					PreparedStatement preparedStatement=connexion.prepareStatement("select cin ,nom , prenom ,telephone ,addresse ,email ,mot_passe, ville ,nom_hotel from admin_local r,hotel h where r.id_hotel=h.id_hotel and email=? ;");
		    		preparedStatement.setString( 1,request.getParameter("email"));
		    		resultat = preparedStatement.executeQuery();
		    		System.out.println("************=>>"+preparedStatement);
		    	    while ( resultat.next() ) { 
		    	    	rec=new Admin_local();
		    	    	rec.setCin(resultat.getString("cin"));
						rec.setNom(resultat.getString("nom"));
						rec.setPrenom(resultat.getString("prenom"));
						rec.setTelephone(resultat.getString("telephone"));
						rec.setEmail(resultat.getString("email"));
						rec.setAddresse(resultat.getString("addresse"));
						rec.setMot_passe(resultat.getString("mot_passe"));
						rec.setVille_hotel(resultat.getString("ville"));
						rec.setNom_hotel(resultat.getString("nom_hotel"));
		    	    }
		    	} catch ( SQLException e ) {
		    	   e.printStackTrace();
		    	} finally {
		    	    if ( connexion != null )
		    	        try {
		    	            /* Fermeture de la connexion */
		    	            connexion.close();
		    	        } catch ( SQLException ignore ) {
		    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		    	        }
		    	}
		    	if(rec!=null) {
		    	if(!rec.getMot_passe().equals(mdp)){
		    		rec=null;
		    	}
		    	}

		        return rec;
		    
	}
		 public Admin_global TestAdmin_global( HttpServletRequest request ) {
		    	String mdp=request.getParameter("password");
		    	Connection connexion=null ;
		    	    ResultSet resultat = null;
		    	    Admin_global c=null;
		    	    try {
			            Class.forName("com.mysql.cj.jdbc.Driver");
			        } catch (ClassNotFoundException e) {
			        	
			        }

			        try {
			            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
		    	try {
		    		PreparedStatement preparedStatement = connexion.prepareStatement( "SELECT * FROM admin_globale WHERE email=?;" );
		    		preparedStatement.setString( 1,request.getParameter("email"));
		    		resultat = preparedStatement.executeQuery();
		    		System.out.println("************=>>"+preparedStatement);
		    	    while ( resultat.next() ) { 
		    	    	c=new Admin_global();
		    	    	c.setCin(resultat.getString( "CIN" ));
		    	    	c.setNom(resultat.getString( "NOM" ));
		    	    	c.setPrenom(resultat.getString( "PRENOM" ));
		    	    	c.setTelephone(resultat.getString( "TELEPHONE" ));
		    	    	c.setMot_passe(resultat.getString( "MOT_PASSE" ));
		    	    	c.setEmail(resultat.getString( "EMAIL" ));
		    	    	c.setAddresse(resultat.getString("ADDRESSE"));
		    	    	
		    	    }
		    	} catch ( SQLException e ) {
		    	   e.printStackTrace();
		    	} finally {
		    	    if ( connexion != null )
		    	        try {
		    	            /* Fermeture de la connexion */
		    	            connexion.close();
		    	        } catch ( SQLException ignore ) {
		    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		    	        }
		    	}
		    	if(c!=null) {
		    	if(!c.getMot_passe().equals(mdp)){
		    		c=null;
		    	}
		    	}

		        return c;
		    
	}
		 
		 
		 public ArrayList<Chambre> getAllchambres(int id_hotel){
				ArrayList<Chambre> chambres = new ArrayList<Chambre>();
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					statement=connexion.createStatement();
					
					PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM chambre where id_hotel=? ;" );
					preparedStatement.setInt( 1,id_hotel);
					resultat = preparedStatement.executeQuery();
					Chambre c=null;
					while(resultat.next()) {
						c=new Chambre();
						c.setId_hotel(resultat.getInt( "id_hotel" ));
						c.setNombre_place(resultat.getInt( "NOMBRE_PLACE"));
						c.setNumero_chambre(resultat.getInt("NUMERO_CHAMBRE"));
						c.setPrix_jour(resultat.getDouble("PRIX_JOUR"));
						c.setType_chambre(resultat.getString("TYPE_CHAMBRE"));
						chambres.add(c);
					}
					
					
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				return chambres;
			}
		 
		 
		 
		 public ArrayList<Admin_local> getAllAdminLocal(){
				ArrayList<Admin_local> admin_local = new ArrayList<Admin_local>();
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					statement=connexion.createStatement();
					resultat = statement.executeQuery( "SELECT cin,prenom,nom,telephone,email,addresse,mot_passe,nom_hotel,ville FROM admin_local,hotel where admin_local.id_hotel=hotel.id_hotel;" );
					Admin_local r=null;
					while(resultat.next()) {
						r=new Admin_local();
						
						r.setCin(resultat.getString("cin"));
						r.setNom(resultat.getString("nom"));
						r.setPrenom(resultat.getString("prenom"));
						r.setTelephone(resultat.getString("telephone"));
						r.setEmail(resultat.getString("email"));
						r.setAddresse(resultat.getString("addresse"));
						r.setVille_hotel(resultat.getString("ville"));
						r.setNom_hotel(resultat.getString("nom_hotel"));
						r.setMot_passe(resultat.getString("mot_passe"));
						admin_local.add(r);
					}
					
					
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				return admin_local;
			}
		 
		 public void changeAdmiLocal(String cin, String prenom, String nom, String telephone, String email, String addresse,
					String mot_passe, String ville_hotel, String nom_hotel) {
					System.out.println(cin);
					ResultSet resultat =null;
					loadDatabase();
					try {
						PreparedStatement preparedStatement=connexion.prepareStatement("update admin_local set nom=? , prenom=? , telephone=?,email=?, addresse=?, mot_passe=?,id_hotel=?  where cin=? ;");
						preparedStatement.setString(1,nom);
						preparedStatement.setString(2,prenom);
						preparedStatement.setString(3,telephone);
						preparedStatement.setString(4,email);
						preparedStatement.setString(5,addresse);
						preparedStatement.setString(6,mot_passe);
						preparedStatement.setInt(7,getId_hotelDb(ville_hotel ,nom_hotel));
						preparedStatement.setString(8,cin);
						System.out.println("lllllllllllll<<<<<<<"+preparedStatement);
						preparedStatement.executeUpdate();
					}catch (SQLException e) {
						e.printStackTrace();
						
					}finally {
						try {
							if(resultat !=null)
								resultat.close();
							if(connexion !=null)
								connexion.close();	
						}catch (SQLException ignore) {
							ignore.printStackTrace();
						}
						
						
					}
				}
		 
		 //mois et le nombre des reservation de cette annee
		 public HashMap<Integer, Integer> statistiqueLocalmonth(int id_hotel) {

			 	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					
					statement=connexion.createStatement();
					//PreparedStatement preparedStatement=connexion.prepareStatement("select NUMERO_CHAMBRE ,NOMBRE_PLACE ,TYPE_CHAMBRE ,PRIX_JOUR ,c.ID_HOTEL from chambre c,hotel h where c.id_hotel=h.id_hotel and c.id_hotel=? and NUMERO_CHAMBRE=? ;");
					PreparedStatement preparedStatement=connexion.prepareStatement("select month(date_debut),count(*) from reservation where id_hotel=? and year(date_debut)=? group by month(date_debut);");
					int year = Calendar.getInstance().get(Calendar.YEAR);
					preparedStatement.setInt(1,id_hotel);
					preparedStatement.setInt(2,year);
					System.out.println(preparedStatement);
					resultat=preparedStatement.executeQuery();
					
					
					while(resultat.next()) {
						map.put(resultat.getInt("month(date_debut)")-1,resultat.getInt("count(*)"));
					}
					
					
				}catch (SQLException e) {
					System.out.println("probleme de reservation");
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();
						return map;
						
					}catch (SQLException ignore) {
						ignore.printStackTrace();
						
					}
					
					
				}
				return map;
				
			}
			//id hotel nb reservation de ce dernier mois
			public HashMap<Integer, Integer> statistiquegloballastemonth() {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				
				
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					
					statement=connexion.createStatement();
					//PreparedStatement preparedStatement=connexion.prepareStatement("select NUMERO_CHAMBRE ,NOMBRE_PLACE ,TYPE_CHAMBRE ,PRIX_JOUR ,c.ID_HOTEL from chambre c,hotel h where c.id_hotel=h.id_hotel and c.id_hotel=? and NUMERO_CHAMBRE=? ;");
					PreparedStatement preparedStatement=connexion.prepareStatement("select count(*),id_hotel from reservation where month(date_debut)=? and year(date_debut)=? group by id_hotel");
					int year = Calendar.getInstance().get(Calendar.YEAR);
					int month=Calendar.getInstance().get(Calendar.MONTH);
					preparedStatement.setInt(1,month-1);
					preparedStatement.setInt(2,year);
					System.out.println(preparedStatement);
					resultat=preparedStatement.executeQuery();
					
					
					while(resultat.next()) {
						map.put(resultat.getInt("id_hotel"),resultat.getInt("count(*)"));	
					}
					
					
				}catch (SQLException e) {
					System.out.println("probleme de reservation");
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();
						return map;
						
					}catch (SQLException ignore) {
						ignore.printStackTrace();
						
					}
					
					
				}
				return map;
				
			}
			
			//id hotel nb des reservation l annees dernier 
			public HashMap<Integer, Integer> statistiquegloballasteyear() {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				
				
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					
					statement=connexion.createStatement();
					//PreparedStatement preparedStatement=connexion.prepareStatement("select NUMERO_CHAMBRE ,NOMBRE_PLACE ,TYPE_CHAMBRE ,PRIX_JOUR ,c.ID_HOTEL from chambre c,hotel h where c.id_hotel=h.id_hotel and c.id_hotel=? and NUMERO_CHAMBRE=? ;");
					PreparedStatement preparedStatement=connexion.prepareStatement("select count(*),id_hotel from reservation where year(date_debut)=? group by id_hotel");
					int year = Calendar.getInstance().get(Calendar.YEAR);
					preparedStatement.setInt(1,year-1);
					System.out.println(preparedStatement);
					resultat=preparedStatement.executeQuery();
					
					
					while(resultat.next()) {
						map.put(resultat.getInt("id_hotel"),resultat.getInt("count(*)"));	
					}
					
					
				}catch (SQLException e) {
					System.out.println("probleme de reservation");
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();
						return map;
						
					}catch (SQLException ignore) {
						ignore.printStackTrace();
						
					}
					
					
				}
				return map;
				
			}
			
			public ArrayList<Hotel> getAllhotel(){
				ArrayList<Hotel> hotel = new ArrayList<Hotel>();
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					statement=connexion.createStatement();
					resultat = statement.executeQuery( "SELECT * from hotel;" );
					Hotel r=null;
					while(resultat.next()) {
						r=new  Hotel();
						r.setId(resultat.getInt("id_hotel"));
						r.setNom(resultat.getString("Nom_HOTEL"));
						r.setVille(resultat.getString("VILLE"));
						r.setAdresse(resultat.getString("ADRESSE"));
						r.setNombre_etoile(resultat.getInt("NOMBRE_ETOILE"));
						r.setNombre_chambre(resultat.getInt("NOMBRE_CHAMBRE"));
						hotel.add(r);
					}
					
					
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				return hotel;
			}
			
			
			
			public void changeHotel(int id, String nom,int nombre_chambre,int nombre_etoile) {
				System.out.println(id);
				ResultSet resultat =null;
				loadDatabase();
				try {
					PreparedStatement preparedStatement=connexion.prepareStatement("update hotel set Nom_HOTEL=? , NOMBRE_CHAMBRE=? , NOMBRE_ETOILE=? where ID_HOTEL=? ;");
					preparedStatement.setString(1,nom);
					preparedStatement.setInt(2,nombre_chambre);
					preparedStatement.setInt(3,nombre_etoile);
					preparedStatement.setInt(4,id);
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
			}
			
			
			public void changeChambre(int id_hotel,int numero_chambre,String type_chambre,int nombre_place,Double prix_jour) {
				System.out.println(id_hotel);
				ResultSet resultat =null;
				loadDatabase();
				try {
					PreparedStatement preparedStatement=connexion.prepareStatement("update chambre set TYPE_CHAMBRE=? , NOMBRE_PLACE=? , PRIX_JOUR=? where ID_HOTEL=? and NUMERO_CHAMBRE=? ;");
					preparedStatement.setString(1,type_chambre);
					preparedStatement.setInt(2,nombre_place);
					preparedStatement.setDouble(3,prix_jour);
					preparedStatement.setInt(4,id_hotel);
					preparedStatement.setInt(5,numero_chambre);
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
			}
			public ArrayList<Receptionniste> getAllReceptionniste(int id_hotel){
				ArrayList<Receptionniste> receptionniste = new ArrayList<Receptionniste>();
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					PreparedStatement preparedStatement=connexion.prepareStatement("SELECT cin,prenom,nom,telephone,email,addresse,mot_passe,nom_hotel,ville FROM receptionniste,hotel where receptionniste.id_hotel=hotel.id_hotel and hotel.id_hotel=?;" );
					preparedStatement.setInt(1,id_hotel);
					resultat=preparedStatement.executeQuery();
					Receptionniste r=null;
					while(resultat.next()) {
						r=new  Receptionniste(resultat.getString("cin"),resultat.getString("prenom"),resultat.getString("nom"),resultat.getString("telephone"),resultat.getString("email"),resultat.getString("addresse"),resultat.getString("mot_passe"),resultat.getString("ville"),resultat.getString("nom_hotel"));
						
						receptionniste.add(r);
					}
					
					
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				return receptionniste;
			}
			public void supprimer_ADMINLOCAL(String cin) {
				System.out.println("ajouter travail          ffffffffffffffffffffffffffffffffff");
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
			
					statement=connexion.createStatement();
					PreparedStatement preparedStatement=connexion.prepareStatement("delete from admin_local where cin=? ;");
					preparedStatement.setString(1,cin);			
					System.out.println("modifier stat------------->"+preparedStatement);
					preparedStatement.executeUpdate();
					System.out.println("first");
					System.out.println("receptionniste  bien supp");
				}catch (SQLException e) {
					System.out.println("probleme de enregistrement");
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				
			}
			public ArrayList<Client> getAllClients(){
				ArrayList<Client> clients = new ArrayList<Client>();
				ResultSet resultat =null;
				PreparedStatement preparedStatement=null;
				loadDatabase();
				try {
					 preparedStatement=connexion.prepareStatement("SELECT * from client;" );
					resultat=preparedStatement.executeQuery();
					Client c=null;
					while(resultat.next()) {
						c=new  Client(resultat.getString("cin"),resultat.getString("nom"),resultat.getString("prenom"),resultat.getString("telephone"),resultat.getString("email"),resultat.getString("addresse"),resultat.getString("mot_passe"));
						
						clients.add(c);
					}
					
					
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(preparedStatement !=null)
							preparedStatement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				return clients;
			}
			
			public ArrayList<Reservation> getReservations(String cin,int id_hotel,String type){
				ArrayList<Reservation> reservations = new ArrayList<Reservation>();
				ResultSet resultat =null;
				PreparedStatement preparedStatement=null;
				loadDatabase();
				try {
					 preparedStatement=connexion.prepareStatement("SELECT * from reservation where cin_client=? and id_hotel=? and validation=?;" );
					 preparedStatement.setString( 1,cin);
					 preparedStatement.setInt( 2,id_hotel);
					 preparedStatement.setString(3,type);
					resultat=preparedStatement.executeQuery();
					Reservation r=null;
					while(resultat.next()) {
						r=new Reservation(resultat.getInt("id_reservation"),resultat.getDate("date_debut"),resultat.getDate("date_fin"),resultat.getString("validation"),resultat.getString("cin_client"),resultat.getInt("id_hotel"),resultat.getInt("numero_chambre"));
						reservations.add(r);
					}
					
					
				}catch (SQLException e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(preparedStatement !=null)
							preparedStatement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				return reservations;
			}
			public int ajouter_CHAMBRE(Chambre chambre,int a,int b) {
				System.out.println("ajouter chambre         ffffffffffffffffffffffffffffffffff");
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					System.out.println("ajouter employer work        ffffffffffffffffffffffffffffffffff");
			
					statement=connexion.createStatement();
					PreparedStatement preparedStatement;
					int i;
					for(i=a;i<=b;i++) {
					preparedStatement=connexion.prepareStatement("insert into chambre values(?,?,?,?,?);" );//update hotel set NOMBRE_CHAMBRE=NOMBRE_CHAMBRE+1 where id_hotel=? ;");
					preparedStatement.setInt(1,i);
					preparedStatement.setInt(2,chambre.getNombre_place());
					preparedStatement.setString(3,chambre.getType_chambre());
					preparedStatement.setDouble(4,chambre.getPrix_jour());
					preparedStatement.setInt(5,chambre.getId_hotel());
					
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
					preparedStatement=connexion.prepareStatement("update hotel set NOMBRE_CHAMBRE=NOMBRE_CHAMBRE+1 where id_hotel=? ;");
					preparedStatement.setInt(1,chambre.getId_hotel());
					System.out.println(preparedStatement);
					preparedStatement.executeUpdate();
					}
					System.out.println("first");
					System.out.println("receptionniste  bien enregistrer");
				}catch (SQLException e) {
					System.out.println("probleme de enregistrement");
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();	
					}catch (SQLException ignore) {
						ignore.printStackTrace();
					}
					
					
				}
				return 1;
			}
			
			public int maxnumero_chambre(int id_hotel) {
				int a=0;
				
				
				Statement statement = null;
				ResultSet resultat =null;
				loadDatabase();
				try {
					
					statement=connexion.createStatement();
					//PreparedStatement preparedStatement=connexion.prepareStatement("select NUMERO_CHAMBRE ,NOMBRE_PLACE ,TYPE_CHAMBRE ,PRIX_JOUR ,c.ID_HOTEL from chambre c,hotel h where c.id_hotel=h.id_hotel and c.id_hotel=? and NUMERO_CHAMBRE=? ;");
					PreparedStatement preparedStatement=connexion.prepareStatement("select max(numero_chambre) from chambre where id_hotel=?;");
					
					preparedStatement.setInt(1,id_hotel);
					
					System.out.println(preparedStatement);
					resultat=preparedStatement.executeQuery();
					
					
					while(resultat.next()) {
						a=resultat.getInt("max(numero_chambre)");	
					}
					
					
				}catch (SQLException e) {
					System.out.println("probleme de reservation");
					e.printStackTrace();
					
				}finally {
					try {
						if(resultat !=null)
							resultat.close();
						if(statement !=null)
							statement.close();
						if(connexion !=null)
							connexion.close();
						return a;
						
					}catch (SQLException ignore) {
						ignore.printStackTrace();
						
					}
					
					
				}
				return a;
				
			}
			 public void removeClient(String cin){
					PreparedStatement preparedStatement=null;
					loadDatabase();
					try {
						 preparedStatement=connexion.prepareStatement("delete from client where cin=?;" );
						 preparedStatement.setString( 1,cin);
						preparedStatement.executeUpdate();	
						preparedStatement=connexion.prepareStatement("update reservation set validation='annuler' where cin_client=? and (validation='true' or validation='false');" );
						 preparedStatement.setString( 1,cin);
						 preparedStatement.executeUpdate();
					}catch (SQLException e) {
						e.printStackTrace();
						
					}finally {
						try {
							if(preparedStatement !=null)
								preparedStatement.close();
							if(connexion !=null)
								connexion.close();	
						}catch (SQLException ignore) {
							ignore.printStackTrace();
						}
						
						
					}
				}
			 public Hoteldata getHotelData(int id_hotel) {
				 Hoteldata r=null;
					ResultSet resultat =null;
					PreparedStatement preparedStatement=null;
					loadDatabase();
					try {
						 preparedStatement=connexion.prepareStatement("select * from hotel where id_hotel=?;");
						preparedStatement.setInt(1,id_hotel);		
						System.out.println(preparedStatement);
						resultat=preparedStatement.executeQuery();
						resultat.next();
						Hotel h=new Hotel(id_hotel,resultat.getString("nom_hotel"),resultat.getString("ville"),resultat.getString("adresse"),resultat.getInt("nombre_chambre"),resultat.getInt("nombre_etoile"));
						 
						preparedStatement=connexion.prepareStatement("select count(*) from receptionniste where id_hotel=?;");
							preparedStatement.setInt(1,id_hotel);		
							System.out.println(preparedStatement);
							resultat=preparedStatement.executeQuery();
							resultat.next();
							int nbrecept=resultat.getInt("count(*)");
							
							 preparedStatement=connexion.prepareStatement("select count(*) from admin_local where id_hotel=?;");
								preparedStatement.setInt(1,id_hotel);		
								System.out.println(preparedStatement);
								resultat=preparedStatement.executeQuery();
								resultat.next();
								int nbadminlocal=resultat.getInt("count(*)");
								
								
								 preparedStatement=connexion.prepareStatement("select count(*) from reservation where id_hotel=? and year(date_debut)=?;");
									preparedStatement.setInt(1,id_hotel);
									int year = Calendar.getInstance().get(Calendar.YEAR);
									preparedStatement.setInt(2,year);
									System.out.println(preparedStatement);
									resultat=preparedStatement.executeQuery();
									resultat.next();
									int nbreservationtotal=resultat.getInt("count(*)");
									
									preparedStatement=connexion.prepareStatement("select count(*) from reservation where id_hotel=? and year(date_debut)=? and VALIDATION='annuler';");
									preparedStatement.setInt(1,id_hotel);
									preparedStatement.setInt(2,year);
									System.out.println(preparedStatement);
									resultat=preparedStatement.executeQuery();
									resultat.next();
									int nbreservationannuler=resultat.getInt("count(*)");
									
									preparedStatement=connexion.prepareStatement("select count(*) from reservation where id_hotel=? and year(date_debut)=? and VALIDATION='false';");
									preparedStatement.setInt(1,id_hotel);
									preparedStatement.setInt(2,year);
									System.out.println(preparedStatement);
									resultat=preparedStatement.executeQuery();
									resultat.next();
									int nbreservationfalse=resultat.getInt("count(*)");
									
									preparedStatement=connexion.prepareStatement("select count(*) from reservation where id_hotel=? and year(date_debut)=? and VALIDATION='true';");
									preparedStatement.setInt(1,id_hotel);
									preparedStatement.setInt(2,year);
									System.out.println(preparedStatement);
									resultat=preparedStatement.executeQuery();
									resultat.next();
									int nbreservationtrue=resultat.getInt("count(*)");
									
								preparedStatement=connexion.prepareStatement("select avg(note) from appreciation a,reservation r where a.ID_RESERVATION=r.ID_RESERVATION and id_hotel=?;");
								
									preparedStatement.setInt(1,id_hotel);		
									System.out.println(preparedStatement);
									resultat=preparedStatement.executeQuery();
									resultat.next();
									int myennote=resultat.getInt("avg(note)");
									
								preparedStatement=connexion.prepareStatement("select count(*) from reclamation a ,reservation r where a.ID_RESERVATION=r.ID_RESERVATION and id_hotel=? and year(date_debut)=?;");
									preparedStatement.setInt(1,id_hotel);
									preparedStatement.setInt(2,year);
									
									System.out.println(preparedStatement);
									resultat=preparedStatement.executeQuery();
									resultat.next();
									int nbreclamation=resultat.getInt("count(*)");
								r=new Hoteldata(h,nbrecept,nbadminlocal,nbreservationannuler,nbreservationtrue,nbreservationfalse,nbreservationtotal, myennote, nbreclamation);
								System.out.println("receptionniste:"+nbrecept+"   local"+nbadminlocal+"  reservation "+nbreservationtotal +" false  "+nbreservationfalse +"  true "+nbreservationtrue + "note "+myennote +"   nbreclamation "+nbreclamation);
					}catch (SQLException e) {
						System.out.println("probleme de enregistrement");
						e.printStackTrace();
						
					}finally {
						try {
							if(resultat !=null)
								resultat.close();
							if(preparedStatement !=null)
								preparedStatement.close();
							if(connexion !=null)
								connexion.close();	
						}catch (SQLException ignore) {
							ignore.printStackTrace();
						}
						
						
					}
					return r;
				}
			 
			 
			 public void annuler_reservation(int id_hotel){
					PreparedStatement preparedStatement=null;
					loadDatabase();
					try {
						preparedStatement=connexion.prepareStatement("update reservation set validation='annuler' where id_hotel=? and validation='false' and date_debut < CURDATE() ;" ); 
						preparedStatement.setInt( 1,id_hotel);
						 System.out.println("voila-----------------------------======>"+preparedStatement);
						 preparedStatement.executeUpdate();
					}catch (SQLException e) {
						e.printStackTrace();
						
					}finally {
						try {
							if(preparedStatement !=null)
								preparedStatement.close();
							if(connexion !=null)
								connexion.close();	
						}catch (SQLException ignore) {
							ignore.printStackTrace();
						}
						
						
					}
				}
			 
			 public void annuler_reservationclient(String cin){
					PreparedStatement preparedStatement=null;
					loadDatabase();
					try {
						preparedStatement=connexion.prepareStatement("update reservation set validation='annuler' where CIN_CLIENT=? and validation='false' and date_debut < CURDATE() ;" ); 
						preparedStatement.setString(1,cin);
						 System.out.println("voila-----------------------------======>"+preparedStatement);
						 preparedStatement.executeUpdate();
					}catch (SQLException e) {
						e.printStackTrace();
						
					}finally {
						try {
							if(preparedStatement !=null)
								preparedStatement.close();
							if(connexion !=null)
								connexion.close();	
						}catch (SQLException ignore) {
							ignore.printStackTrace();
						}
						
						
					}
				}
			 
			 
			 public String savePhoto(InputStream inputStream ,int id_hotel,int position) {
				 Connection conn = null; 
			        String message = null; 
			         String dbURL = "jdbc:mysql://localhost:3306/S4?useTimezone=true&serverTimezone=UTC";
			         String dbUser = "root";
			         String dbPass = "root";
			         
			        try {
			            // connects to the database
			            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
			 
			            // constructs SQL statement
			            String sql = "INSERT INTO photos_hotel values (?, ?, ?)";
			            PreparedStatement statement = conn.prepareStatement(sql);
			            statement.setInt(1, id_hotel);
			            statement.setInt(2,position);     
			            if (inputStream != null) {
			                // fetches input stream of the upload file for the blob column
			                statement.setBlob(3, inputStream);
			            }
			 
			            // sends the statement to the database server
			            int row = statement.executeUpdate();
			            if (row > 0) {
			                message = "File uploaded and saved into database";
			            }
			        } catch (SQLException ex) {
			            message = "ERROR: " + ex.getMessage();
			            ex.printStackTrace();
			        } finally {
			            if (conn != null) {
			                // closes the database connection
			                try {
			                    conn.close();
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                }
			}
			        }
			        return message;
			}
			 
			 
			 public ArrayList<Reclamation> getreclamation(int id_reservation) {
					Statement statement = null;
					ResultSet resultat =null;
					loadDatabase();
					ArrayList<Reclamation> reclamations=null;
					int count=0;
					Reclamation r=new Reclamation();
					try {
						
						statement=connexion.createStatement();
						PreparedStatement preparedStatement=connexion.prepareStatement("select count(*) from reclamation where id_reservation=? ;");
						preparedStatement.setInt(1,id_reservation);
						resultat=preparedStatement.executeQuery();
						resultat.next();
						count=resultat.getInt("count(*)");
						if(count!=0) {
						reclamations=new ArrayList<Reclamation>();
						preparedStatement=connexion.prepareStatement("select  * from reclamation where id_reservation=? ;");
						preparedStatement.setInt(1,id_reservation);
						System.out.println(preparedStatement);
						resultat=preparedStatement.executeQuery();
						while(resultat.next()) {
							r=new Reclamation();
							r.setId_reservation(resultat.getInt("id_reservation"));
							r.setId_recalamtion(resultat.getInt("id_reclamation"));
							r.setText(resultat.getString("text_reclamation"));
							r.setType(resultat.getString("type_reclamation"));
							reclamations.add(r);
						}
						}
					}catch (SQLException e) {
						System.out.println("probleme de reservation");
						e.printStackTrace();
						
					}finally {
						try {
							if(resultat !=null)
								resultat.close();
							if(statement !=null)
								statement.close();
							if(connexion !=null)
								connexion.close();
							
						}catch (SQLException ignore) {
							ignore.printStackTrace();
							
						}
						
						
					}
					return reclamations;
				}
			 
			 
			 
			 public int addRating(int id_reservation, float rating) {
			    	int statut=0;
			    	Connection connexion=null ;
			    	    ResultSet resultat = null;
			    	    try {
				            Class.forName("com.mysql.cj.jdbc.Driver");
				        } catch (ClassNotFoundException e) {
				        	
				        }

				        try {
				            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

				        } catch (SQLException e) {
				            e.printStackTrace();
				        }
			    	try {
			    		PreparedStatement preparedStatement = connexion.prepareStatement( "INSERT INTO appreciation VALUES(null,?, ?);" );
			    		preparedStatement.setFloat( 1, rating);
			    		preparedStatement.setInt( 2,id_reservation);
			    		 statut = preparedStatement.executeUpdate();
			    	} catch ( SQLException e ) {
				    	   e.printStackTrace();
				    	} finally {
				    	    if ( connexion != null )
				    	        try {
				    	            /* Fermeture de la connexion */
				    	            connexion.close();
				    	        } catch ( SQLException ignore ) {
				    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
				    	        }
				    	}
			    	return statut;
			    	
			    }
				public float getRating(int id_reservation) {
					float Rating=0; 
					Statement statement = null;
					ResultSet resultat =null;
					loadDatabase();
					int count=0;
					try {
						
						statement=connexion.createStatement();
						PreparedStatement preparedStatement=connexion.prepareStatement("select count(*) from appreciation where id_reservation=? ;");
						preparedStatement.setInt(1,id_reservation);
						resultat=preparedStatement.executeQuery();
						resultat.next();
						count=resultat.getInt("count(*)");
						if(count!=0) {
						preparedStatement=connexion.prepareStatement("select note  from appreciation where id_reservation=? ;");
						preparedStatement.setInt(1,id_reservation);
						resultat=preparedStatement.executeQuery();
						resultat.next();
							Rating=resultat.getFloat("note");	
						}
					}catch (SQLException e) {
						System.out.println("probleme de reservation");
						e.printStackTrace();
						
					}finally {
						try {
							if(resultat !=null)
								resultat.close();
							if(statement !=null)
								statement.close();
							if(connexion !=null)
								connexion.close();
							
						}catch (SQLException ignore) {
							ignore.printStackTrace();
							
						}
						
						
					}
					return Rating;
				}
				
				
				public int addreclamation(String type, String text,int id) {
			    	int statut=0;
			    	Connection connexion=null ;
			    	    ResultSet resultat = null;
			    	    try {
				            Class.forName("com.mysql.cj.jdbc.Driver");
				        } catch (ClassNotFoundException e) {
				        	
				        }

				        try {
				            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

				        } catch (SQLException e) {
				            e.printStackTrace();
				        }
			    	try {
			    		PreparedStatement preparedStatement = connexion.prepareStatement( "INSERT INTO reclamation VALUES(null,?, ?,?);" );
			    		preparedStatement.setString( 1,type);
			    		preparedStatement.setString( 2,text);
			    		preparedStatement.setInt( 3,id);
			    		System.out.println(preparedStatement);
			    		 statut = preparedStatement.executeUpdate();
			    	} catch ( SQLException e ) {
				    	   e.printStackTrace();
				    	} finally {
				    	    if ( connexion != null )
				    	        try {
				    	            /* Fermeture de la connexion */
				    	            connexion.close();
				    	        } catch ( SQLException ignore ) {
				    	            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
				    	        }
				    	}
			    	return statut;
			    	
			    }
				public void changeReclamation(Reclamation r) {
			    	Connection connexion=null ;
			    	    ResultSet resultat;
			    	    Client c=null;
			    	    try {
				            Class.forName("com.mysql.cj.jdbc.Driver");
				        } catch (ClassNotFoundException e) {
				        	
				        }

				        try {
				            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

				        } catch (SQLException e) {
				            e.printStackTrace();
				        }
			    	try {

			    		PreparedStatement preparedStatement = connexion.prepareStatement( "UPDATE reclamation SET type_reclamation=?,text_reclamation=? WHERE id_reclamation=?" );
			    		preparedStatement.setString( 1,r.getType());
			    		preparedStatement.setString( 2, r.getText());
			    		preparedStatement.setInt( 3, r.getId_reclamation());
			    		preparedStatement.executeUpdate();
			    	} catch ( SQLException e ) {
			    	   e.printStackTrace();
			    	} finally {
			    	    if ( connexion != null )
			    	        try {
			    	            connexion.close();
			    	        } catch ( SQLException ignore ) {
			    	        }
			    	}
			    	}
				  public void cancelReclamation(int id) {
						Statement statement = null;
						ResultSet resultat =null;
						loadDatabase();
						try {
							statement=connexion.createStatement();
							PreparedStatement preparedStatement=connexion.prepareStatement("delete from reclamation where id_reclamation=? ;");
							preparedStatement.setInt(1,id);			
							preparedStatement.executeUpdate();
						}catch (SQLException e) {
							System.out.println("probleme de enregistrement");
							e.printStackTrace();
							
						}finally {
							try {
								if(resultat !=null)
									resultat.close();
								if(statement !=null)
									statement.close();
								if(connexion !=null)
									connexion.close();	
							}catch (SQLException ignore) {
								ignore.printStackTrace();
							}
							
							
						}
						
					}
				  public ArrayList<Reclamation> getReclamation(int id_hotel){
						ArrayList<Reclamation> reclamations = new ArrayList<Reclamation>();
						ResultSet resultat =null;
						PreparedStatement preparedStatement=null;
						loadDatabase();
						try {
							 preparedStatement=connexion.prepareStatement("select type_reclamation,text_reclamation,date_debut,date_fin,nom,prenom,cin from reclamation join reservation on reclamation.id_reservation=reservation.id_reservation join client on cin_client=cin  where reservation.id_hotel=? and DATEDIFF(CURDATE(),date_debut)<30 and DATEDIFF(CURDATE(),date_debut)>0 ;" );
							 preparedStatement.setInt( 1,id_hotel);
							resultat=preparedStatement.executeQuery();
							Reclamation r=null;
							while(resultat.next()) {
								r=new Reclamation(0,0,resultat.getString("type_reclamation"),resultat.getString("text_reclamation"),resultat.getString("nom"),resultat.getString("prenom"),resultat.getDate("date_debut"), resultat.getString("cin"),resultat.getDate("date_fin"));
								reclamations.add(r);
							}
							
							
						}catch (SQLException e) {
							e.printStackTrace();
							
						}finally {
							try {
								if(resultat !=null)
									resultat.close();
								if(preparedStatement !=null)
									preparedStatement.close();
								if(connexion !=null)
									connexion.close();	
							}catch (SQLException ignore) {
								ignore.printStackTrace();
							}
							
							
						}
						return reclamations;
					}
				  
				  
				  public photos_hotel getphotoh(int id_hotel,int position)  {
						String databaseURL = "jdbc:mysql://localhost:3306/S4?useTimezone=true&serverTimezone=UTC";
					    String user = "root";
					    String password = "root";
					       photos_hotel c = null;
					         
					        String sql = "SELECT * FROM photos_hotel WHERE id_hotel = ? and position=?;";
					         
					        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
					            PreparedStatement statement = connection.prepareStatement(sql);
					            statement.setInt(1, id_hotel);
					            statement.setInt(2, position);
					            ResultSet result = statement.executeQuery();
					             
					            if (result.next()) {
					                c = new photos_hotel();
					                Blob blob = result.getBlob("photo");
					                 
					                InputStream inputStream = blob.getBinaryStream();
					                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					                byte[] buffer = new byte[4096];
					                int bytesRead = -1;
					                 
					                while ((bytesRead = inputStream.read(buffer)) != -1) {
					                    outputStream.write(buffer, 0, bytesRead);                  
					                }
					                 
					                byte[] imageBytes = outputStream.toByteArray();
					                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					                 
					                 
					                inputStream.close();
					                outputStream.close();
					                 
					                c.setId_hotel(id_hotel);
					                c.setPosition(position);
					                c.setBase64Image(base64Image);
					            }          
					             
					        } catch (SQLException | IOException ex) {
					            ex.printStackTrace();
					            
					        }      
					         
					        return c;
					    }
				  
				  
				  
				  public void changeHotel(int id, String nom, int nombre_etoile) {
						System.out.println(id);
						ResultSet resultat =null;
						loadDatabase();
						try {
							PreparedStatement preparedStatement=connexion.prepareStatement("update hotel set Nom_HOTEL=? , NOMBRE_ETOILE=? where ID_HOTEL=? ;");
							preparedStatement.setString(1,nom);
							preparedStatement.setInt(2,nombre_etoile);
							preparedStatement.setInt(3,id);
							System.out.println(preparedStatement);
							preparedStatement.executeUpdate();
						}catch (SQLException e) {
							e.printStackTrace();
							
						}finally {
							try {
								if(resultat !=null)
									resultat.close();
								if(connexion !=null)
									connexion.close();	
							}catch (SQLException ignore) {
								ignore.printStackTrace();
							}
							
							
						}
					}
}
