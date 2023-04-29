package com.fight.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fight.client.dao.ReservationDao;
import com.fight.client.dto.ReservationRequest;
import com.fight.client.model.Reservation;
import com.fight.model.Flight;
import com.fight.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
		@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findReservationrById(int id) {
		return reservationDao.findReservationrById(id);
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationDao.addReservation(reservation);
	}

	@Override
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReservation(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		Reservation reservation = reservationDao.bookFlight(reservationRequest);
		return reservation;
	}

}
