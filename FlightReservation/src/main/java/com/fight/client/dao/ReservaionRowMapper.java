package com.fight.client.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fight.client.model.Reservation;

public class ReservaionRowMapper implements RowMapper<Reservation> {

	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reservation reservation = new Reservation();
		reservation.setId(rs.getInt("ID"));
		reservation.setCheckedIn(rs.getBoolean("CHECKED_IN"));
		reservation.setNumberOfBags(rs.getInt("NUMBER_OF_BAGS"));
		reservation.setPassengerId(rs.getInt("PASSENGER_ID"));
		reservation.setFlightId(rs.getInt("FLIGHT_ID"));
		return reservation;
	}

}
