package sdzee.com.beans;

public class ReservationHotel {
	private Reservation reservation;
	private String hotel;
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public ReservationHotel(Reservation reservation, String hotel) {
		super();
		this.reservation = reservation;
		this.hotel = hotel;
	}
	
}
