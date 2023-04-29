public class ReservationDirector {
    public Reservation bookFlight(ReservationRequest reservationRequest, PassengerDao passengerDao, FlightDao flightDao) {
        // make payment logic
        Flight flight = flightDao.findeFlightById(reservationRequest.getFlightId());
        Passenger passenger = new PassengerBuilder()
            .setFirstName(reservationRequest.getPassenerFirstName())
            .setLastName(reservationRequest.getPassenerLastName())
            .setMiddleName(reservationRequest.getPassenerLastName())
            .setEmail(reservationRequest.getPasseneremail())
            .setPhone(reservationRequest.getPassenerPhone())
            .build();
        int passengerId = passengerDao.addPassenger(passenger);
        Reservation reservation = new ReservationBuilder()
            .setCheckedIn(false)
            .setNumberOfBags(reservationRequest.getNumberOfBags())
            .setPassengerId(passengerId)
            .setFlightId(flight.getFlightId())
            .build();
        return reservation;
    }
}
