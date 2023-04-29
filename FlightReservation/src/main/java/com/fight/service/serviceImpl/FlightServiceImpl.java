package com.fight.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fight.daoimpl.FlightDaoImpl;
import com.fight.model.Flight;
import com.fight.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightDaoImpl flighDao;

	@Override
	public List<Flight> getAllFlights() {
		List<Flight> Flights = flighDao.getAllFlights();
		return Flights;
	}

	@Override
	public Flight findeFlightById(int id) {
		Flight flight = flighDao.findeFlightById(id);
		return flight;
	}

	@Override
	public void addFlight(Flight flight) {
		 flighDao.addFlight(flight);
	}

	@Override
	public void updateFlight(Flight flight) {
		flighDao.updateFlight(flight);
	}

	@Override
	public void deleteFlight(int id) {
		flighDao.deleteFlight(id);
	}

	@Override
	public List<Flight> findeFlightByDepartureDate(String departure, String arrival) {
		List<Flight> flights  =flighDao.findeFlightByDepartureDate(departure,arrival);
		return flights;
	}

}
