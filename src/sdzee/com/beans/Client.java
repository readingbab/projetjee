package sdzee.com.beans;

public class Client {
	private String cin;
	private String nom;
	private String prenom;
	private String phone;
	private String email;
	private String addresse;
	private String password;
	
	public Client() {
		
		// TODO Auto-generated constructor stub
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Client(String cin, String nom, String prenom, String phone, String email, String addresse, String password) {
		
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.phone = phone;
		this.email = email;
		this.addresse = addresse;
		this.password = password;
	}
	
	
	
}
