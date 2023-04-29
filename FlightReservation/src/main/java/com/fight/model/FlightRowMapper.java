package com.fight.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FlightRowMapper implements RowMapper<Flight> {

	@Override
	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Flight flight = new Flight();
		flight.setFlightId(rs.getInt("flight_id"));
		flight.setFlightName(rs.getString("flight_name"));
		flight.setDeparture(rs.getString("departure"));
		flight.setArrival(rs.getString("arrival"));
		flight.setDepartureDate(rs.getString("departureDate"));
		flight.setArrivalDate(rs.getString("arrivalDate"));
		return flight;
	}

}
