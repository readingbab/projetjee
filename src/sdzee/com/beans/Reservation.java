package sdzee.com.beans;


import java.util.Date;

public class Reservation {
	private int id_reservation;
	private Date date_debut;
	private Date date_fin;
	private String validation;
	private String cin_client;
	private int id_hotel; 
	private int numero_chambre;
	
	
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
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
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	public String getCin_client() {
		return cin_client;
	}
	public void setCin_client(String cin_client) {
		this.cin_client = cin_client;
	}
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public int getNumero_chambre() {
		return numero_chambre;
	}
	public void setNumero_chambre(int numero_chambre) {
		this.numero_chambre = numero_chambre;
	}
	public Reservation(int id_reservation, Date date_debut, Date date_fin, String validation) {
		
		this.id_reservation = id_reservation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.validation = validation;
	}
	public Reservation() {
		
	}public Reservation(int id_reservation, Date date_debut, Date date_fin, String validation, String cin_client,
			int id_hotel, int numero_chambre) {
		super();
		this.id_reservation = id_reservation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.validation = validation;
		this.cin_client = cin_client;
		this.id_hotel = id_hotel;
		this.numero_chambre = numero_chambre;
	}
	
}
