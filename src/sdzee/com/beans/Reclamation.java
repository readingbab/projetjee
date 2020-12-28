package sdzee.com.beans;

import java.sql.Date;

public class Reclamation {
	private int id_reclamation;
	private int id_reservation;
	private String type;
	private String text;
	private String nom_client;
	private String prenom_client;
	private Date date_debut;
	private String cin_client;
	private Date date_fin;
	
	public Reclamation(int id_reclamation, int id_reservation, String type, String text, String nom_client,
			String prenom_client, Date date_debut, String cin_client, Date date_fin) {
		super();
		this.id_reclamation = id_reclamation;
		this.id_reservation = id_reservation;
		this.type = type;
		this.text = text;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.date_debut = date_debut;
		this.cin_client = cin_client;
		this.date_fin = date_fin;
	}
	public String getCin_client() {
		return cin_client;
	}
	public void setCin_client(String cin_client) {
		this.cin_client = cin_client;
	}
	public String getNom_client() {
		return nom_client;
	}
	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}
	public String getPrenom_client() {
		return prenom_client;
	}
	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public void setId_reclamation(int id_reclamation) {
		this.id_reclamation = id_reclamation;
	}
	
	public Reclamation() {
		super();
	}
	public Reclamation(int id_reclamation, int id_reservation, String type, String text) {
		super();
		this.id_reclamation = id_reclamation;
		this.id_reservation = id_reservation;
		this.type = type;
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public int getId_reclamation() {
		return id_reclamation;
	}
	public void setId_recalamtion(int id_recalamtion) {
		this.id_reclamation = id_recalamtion;
	}
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
