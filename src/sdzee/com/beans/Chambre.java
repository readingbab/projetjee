package sdzee.com.beans;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chambre {
	private int numero_chambre;
	private int nombre_place;
	private String type_chambre;
	private Double prix_jour;
	private int id_hotel;
	public int getNumero_chambre() {
		return numero_chambre;
	}
	public void setNumero_chambre(int numero_chambre) {
		this.numero_chambre = numero_chambre;
	}
	public int getNombre_place() {
		return nombre_place;
	}
	public void setNombre_place(int nombre_place) {
		this.nombre_place = nombre_place;
	}
	public String getType_chambre() {
		return type_chambre;
	}
	public void setType_chambre(String type_chambre) {
		this.type_chambre = type_chambre;
	}
	public Double getPrix_jour() {
		return prix_jour;
	}
	public void setPrix_jour(Double prix_jour) {
		this.prix_jour = prix_jour;
	}
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public Chambre(int numero_chambre, int nombre_place, String type_chambre, Double prix_jour, int id_hotel) {
		
		this.numero_chambre = numero_chambre;
		this.nombre_place = nombre_place;
		this.type_chambre = type_chambre;
		this.prix_jour = prix_jour;
		this.id_hotel = id_hotel;
	}
	public Chambre() {
	}
}
