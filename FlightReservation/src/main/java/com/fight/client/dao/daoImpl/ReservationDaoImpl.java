package com.fight.client.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fight.client.dao.ReservationDao;
import com.fight.client.dto.ReservationRequest;
import com.fight.client.model.Passenger;
import com.fight.client.model.Reservation;

@Transactional
@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation findReservationrById(int id) {
		String query = "SELECT * FROM reservation WHERE id = ?";
		RowMapper<Reservation> rowMapper = new BeanPropertyRowMapper<Reservation>(Reservation.class);
		Reservation reservation = jdbcTemplate.queryForObject(query, rowMapper, id);
		return reservation;
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		String query = "INSERT INTO reservation(CHECKED_IN, NUMBER_OF_BAGS, PASSENGER_ID, FLIGHT_ID) VALUES(:CHECKED_IN, :NUMBER_OF_BAGS, :PASSENGER_ID, :FLIGHT_ID)";
	
		KeyHolder holder = new GeneratedKeyHolder();
	
		 SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("CHECKED_IN",reservation.getCheckedIn())
					.addValue("NUMBER_OF_BAGS",reservation.getNumberOfBags())
					.addValue("PASSENGER_ID", reservation.getPassengerId())
					.addValue("FLIGHT_ID",reservation.getFlightId());
					namedParameterJdbcTemplate.update(query, parameters, holder);
					reservation.setId(holder.getKey().intValue());
			return reservation;
	}
	
	

	@Override
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReservation(int id) {
		 String query = "DELETE FROM reservation WHERE id=?";
		  jdbcTemplate.update(query, id);
	}

	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		// make payment logic
		
//		Flight flight = flightDao.findeFlightById(reservationRequest.getFlightId());
//		
//		Passenger passenger = new Passenger();
//		passenger.setFirstName(reservationRequest.getPassenerFirstName());
//		passenger.setLastName(reservationRequest.getPassenerLastName());
//		passenger.setMiddleName(reservationRequest.getPassenerLastName());
//		passenger.setEmail(reservationRequest.getPasseneremail());
//		passenger.setPhone(reservationRequest.getPassenerPhone());
//		int passengerId = passengerDao.addPassenger(passenger);
//		
//		Reservation reservation = new Reservation();
//		reservation.setPassengerId(passengerId);
//		reservation.setFlightId(flight.getFlightId());
//		reservationDao.addReservation(reservation);
		
		return null;
	}

}
