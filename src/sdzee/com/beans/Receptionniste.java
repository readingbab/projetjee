package sdzee.com.beans;
public class Receptionniste {
	private String cin;
	private String prenom;
	private String nom;
	private String telephone;
	private String email;
	private String addresse;
	private String mot_passe;
	private String ville_hotel;
	private String nom_hotel;
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Receptionniste(String cin, String prenom, String nom, String telephone, String email, String addresse,
			String mot_passe, String ville_hotel, String nom_hotel) {
		super();
		this.cin = cin;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.addresse = addresse;
		this.mot_passe = mot_passe;
		this.ville_hotel = ville_hotel;
		this.nom_hotel = nom_hotel;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getMot_passe() {
		return mot_passe;
	}
	public void setMot_passe(String mot_passe) {
		this.mot_passe = mot_passe;
	}
	public String getVille_hotel() {
		return ville_hotel;
	}
	public void setVille_hotel(String ville_hotel) {
		this.ville_hotel = ville_hotel;
	}
	public String getNom_hotel() {
		return nom_hotel;
	}
	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}
	public Receptionniste() {
		super();
	}
}

