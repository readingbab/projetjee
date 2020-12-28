package sdzee.com.beans;
public class Hotel {
	private int id;
	private String nom;
	private String ville;
	private String adresse;
	private int nombre_chambre;
	private int nombre_etoile;
	
	public Hotel(int id, String nom, String ville, String adresse, int nombre_chambre, int nombre_etoile) {
	
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
		this.nombre_chambre = nombre_chambre;
		this.nombre_etoile = nombre_etoile;
	}
	public Hotel() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNombre_chambre() {
		return nombre_chambre;
	}
	public void setNombre_chambre(int nombre_chambre) {
		this.nombre_chambre = nombre_chambre;
	}
	public int getNombre_etoile() {
		return nombre_etoile;
	}
	public void setNombre_etoile(int nombre_etoile) {
		this.nombre_etoile = nombre_etoile;
	}
	

}

