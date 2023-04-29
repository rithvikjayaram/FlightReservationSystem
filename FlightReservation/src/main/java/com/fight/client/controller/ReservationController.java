package com.fight.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fight.client.dao.PassengerDao;
import com.fight.client.dto.ReservationRequest;
import com.fight.client.model.Passenger;
import com.fight.client.model.Reservation;
import com.fight.model.Flight;
import com.fight.service.FlightService;
import com.fight.service.ReservationService;
@Controller
@RequestMapping("/flights")
public class ReservationController {
	@Autowired
	private FlightReservationFacade flightReservationFacade;	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") int flightId, ModelMap modelMap) {
		Flight flight = flightReservationFacade.getFlightById(flightId);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}	
	@RequestMapping("/reservationCancel")
	public String reservationCancel(@RequestParam("reservationId") int reservationId, ModelMap modelMap) {
		flightReservationFacade.cancelReservation(reservationId);
		modelMap.addAttribute("msg", "your reservation has been canceled for id " + reservationId);
		return "reservationCancel";
	}
	@RequestMapping(value = "/conf", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {
		Reservation reservation = flightReservationFacade.createReservation(reservationRequest);
		modelMap.addAttribute("reservation_user", reservation);
		modelMap.addAttribute("passenger_user", reservation.getPassenger());
		modelMap.addAttribute("flight", reservation.getFlight());
		return "conf";
	}
}
