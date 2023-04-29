public class FlightReservationFacade {
	private FlightService flightService;
	private ReservationService reservationService;
	private PassengerDao passengerDao;	
	public FlightReservationFacade(FlightService flightService, ReservationService reservationService, PassengerDao passengerDao) {
		this.flightService = flightService;
		this.reservationService = reservationService;
		this.passengerDao = passengerDao;
	}
		public Flight getFlightById(int flightId) {
		return flightService.findeFlightById(flightId);
	}
	public Reservation createReservation(ReservationRequest reservationRequest) {
		Flight flight = flightService.findeFlightById(reservationRequest.getFlightId());
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequest.getPassenerFirstName());
		passenger.setLastName(reservationRequest.getPassenerLastName());
		passenger.setMiddleName(reservationRequest.getPassenerLastName());
		passenger.setEmail(reservationRequest.getPasseneremail());
		passenger.setPhone(reservationRequest.getPassenerPhone());
		Passenger passenger2 = passengerDao.addPassenger(passenger);
		int id = passenger2.getId();
		Reservation reservation = new Reservation();
		reservation.setPassengerId(id);
		reservation.setFlightId(flight.getFlightId());
		Reservation addReservation = reservationService.addReservation(reservation);
		return addReservation;
	}
	public void cancelReservation(int reservationId) {
		Reservation reservation = ReservationService.findReservationrById(reservationId);
		int passengerId = reservation.getPassengerId();
		passengerDao.deletePassenger(passengerId);
		reservationService.deleteReservation(reservationId);
	}
}