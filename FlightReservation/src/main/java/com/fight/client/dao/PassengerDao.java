package com.fight.client.dao;

import java.util.List;

import com.fight.client.model.Passenger;

public interface PassengerDao {

	public List<Passenger> getAllPassengers();
	 
	 public Passenger findPassengerById(int id);
	 
	 public Passenger addPassenger(Passenger passenger);
	 
	 public void updatePassenger(Passenger Passenger);
	 
	 public void deletePassenger(int id);
	 
}
