package com.fight.daoimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fight.dao.FlightDao;
import com.fight.model.Flight;
import com.fight.model.FlightRowMapper;

@Transactional
@Repository
public class FlightDaoImpl implements FlightDao {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Flight> getAllFlights() {
		 String query = "SELECT * from flight";
		  RowMapper<Flight> rowMapper = new FlightRowMapper();
		  List<Flight> list = jdbcTemplate.query(query, rowMapper);
		  
		  return list;
	}

	@Override
	public Flight findeFlightById(int id) {
		 String query = "SELECT * FROM flight WHERE flight_id = ?";
		  RowMapper<Flight> rowMapper = new BeanPropertyRowMapper<Flight>(Flight.class);
		  Flight flight = jdbcTemplate.queryForObject(query, rowMapper, id);
		  return flight;
	}

	@Override
	public void addFlight(Flight flight) {
		LocalDate getDepartureDate = LocalDate.parse(flight.getDepartureDate());
		LocalDate getArrivalDate = LocalDate.parse(flight.getArrivalDate());
		
		//String getArrivalDate = formatter.format(LocalDate.parse(flight.getArrivalDate(), formatter));
		
		  String query = "INSERT INTO flight(flight_name, departure, arrival, departureDate, arrivalDate) VALUES(?, ?, ?, ?, ?)";
		  jdbcTemplate.update(query, flight.getFlightName(), flight.getDeparture(), flight.getArrival(),
				  getDepartureDate, getArrivalDate);
		  
	}

	@Override
	public void updateFlight(Flight flight) {
		String query = "UPDATE flight SET flight_name=?, departure=?, arrival=?, departureDate=?, arrivalDate=? WHERE flight_id=?";
		  jdbcTemplate.update(query,flight.getFlightName(), flight.getDeparture(), flight.getArrival(), flight.getDepartureDate(), flight.getArrivalDate(),flight.getFlightId());
	}

	@Override
	public void deleteFlight(int id) {
		 String query = "DELETE FROM flight WHERE flight_id=?";
		  jdbcTemplate.update(query, id);

	}

	@Override
	public List<Flight> findeFlightByDepartureDate(String departure, String arrival) {
		String query = "SELECT * FROM flight WHERE departure like ? and  like ?";
//		return jdbcTemplate.query(query, new Object[] { "%" + departure + "%", "%" + arrival + "%" },
//				(rs, rowNum) -> new Flight()
//				);
		
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("departure", "%" + departure + "%");
        mapSqlParameterSource.addValue("arrival","%" + arrival + "%");
        System.out.println("------->flight"+mapSqlParameterSource);
		
		  
		  return namedParameterJdbcTemplate.query(
				  
				  
	                "SELECT * FROM flight WHERE departure like :departure and arrival like :arrival",
	                mapSqlParameterSource,
	                (rs, rowNum) ->{
	                	Flight flight = new Flight();
	            		flight.setFlightId(rs.getInt("flight_id"));
	            		flight.setFlightName(rs.getString("flight_name"));
	            		flight.setDeparture(rs.getString("departure"));
	            		flight.setArrival(rs.getString("arrival"));
	            		flight.setDepartureDate(rs.getString("departureDate"));
	            		flight.setArrivalDate(rs.getString("arrivalDate"));
	            		return flight;
	                }
	                
	        );

	}
	 

	

}
