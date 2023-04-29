package com.fight.client.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fight.client.model.Passenger;

public class PassengerRowMapper implements RowMapper<Passenger> {

	@Override
	public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Passenger passenger = new Passenger();
		passenger.setId(rs.getInt("ID"));
		passenger.setFirstName(rs.getString("FIRST_NAME"));
		passenger.setMiddleName(rs.getString("MIDDLE_NAME"));
		passenger.setLastName(rs.getString("LAST_NAME"));
		passenger.setEmail(rs.getString("EMAIL"));
		passenger.setPhone(rs.getString("PHONE"));
		return passenger;
	}

}
