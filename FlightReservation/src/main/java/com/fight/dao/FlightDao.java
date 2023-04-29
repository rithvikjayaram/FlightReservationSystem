package com.fight.dao;

import java.util.List;

import com.fight.model.Flight;

public interface FlightDao {
	
	 public List<Flight> getAllFlights();
	 
	 public Flight findeFlightById(int id);
	 
	 public List<Flight> findeFlightByDepartureDate(String departure,String arrival);
	 
	 public void addFlight(Flight Flight);
	 
	 public void updateFlight(Flight Flight);
	 
	 public void deleteFlight(int id);
}
