package com.fight.client.dao;

import java.util.List;

import com.fight.client.dto.ReservationRequest;
import com.fight.client.model.Reservation;


public interface ReservationDao {

	public List<Reservation> getAllReservation();
	 
	 public Reservation findReservationrById(int id);
	 
	 public Reservation addReservation(Reservation reservation);
	 
	 public void updateReservation(Reservation reservation);
	 
	 public void deleteReservation(int id);
	 
	 public Reservation bookFlight(ReservationRequest reservationRequest);
	 
	
	 
}
