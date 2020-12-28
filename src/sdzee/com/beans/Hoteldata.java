package sdzee.com.beans;

public class Hoteldata {
	private Hotel hotel;
	private int nombre_receptionniste;
	private int nombre_local;
	private float nombre_reservation_annuler;
	private float nombre_reservation_valider;
	private float nombre_reservation_encore;
	private float nombre_reservation_total;
	private float note;
	private int nombre_reclamations;
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public int getNombre_receptionniste() {
		return nombre_receptionniste;
	}
	public void setNombre_receptionniste(int nombre_receptionniste) {
		this.nombre_receptionniste = nombre_receptionniste;
	}
	public int getNombre_local() {
		return nombre_local;
	}
	public void setNombre_local(int nombre_local) {
		this.nombre_local = nombre_local;
	}
	public float getNombre_reservation_annuler() {
		return nombre_reservation_annuler;
	}
	public void setNombre_reservation_annuler(float nombre_reservation_annuler) {
		this.nombre_reservation_annuler = nombre_reservation_annuler;
	}
	public float getNombre_reservation_valider() {
		return nombre_reservation_valider;
	}
	public void setNombre_reservation_valider(float nombre_reservation_valider) {
		this.nombre_reservation_valider = nombre_reservation_valider;
	}
	public float getNombre_reservation_encore() {
		return nombre_reservation_encore;
	}
	public void setNombre_reservation_encore(float nombre_reservation_encore) {
		this.nombre_reservation_encore = nombre_reservation_encore;
	}
	public float getNombre_reservation_total() {
		return nombre_reservation_total;
	}
	public void setNombre_reservation_total(float nombre_reservation_total) {
		this.nombre_reservation_total = nombre_reservation_total;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public int getNombre_reclamations() {
		return nombre_reclamations;
	}
	public void setNombre_reclamations(int nombre_reclamations) {
		this.nombre_reclamations = nombre_reclamations;
	}
	public Hoteldata(Hotel hotel, int nombre_receptionniste, int nombre_local, float nombre_reservation_annuler,
			float nombre_reservation_valider, float nombre_reservation_encore, float nombre_reservation_total,
			float note, int nombre_reclamations) {
		this.hotel = hotel;
		this.nombre_receptionniste = nombre_receptionniste;
		this.nombre_local = nombre_local;
		this.nombre_reservation_annuler = nombre_reservation_annuler;
		this.nombre_reservation_valider = nombre_reservation_valider;
		this.nombre_reservation_encore = nombre_reservation_encore;
		this.nombre_reservation_total = nombre_reservation_total;
		this.note = note;
		this.nombre_reclamations = nombre_reclamations;
	}

	
}
