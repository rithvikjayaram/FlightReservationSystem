public class ReservationBuilder {
    private Passenger passenger;
    private Flight flight;
    private int numberOfBags;
    private boolean checkedIn;
    public ReservationBuilder setPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }
    public ReservationBuilder setFlight(Flight flight) {
        this.flight = flight;
        return this;
    }
    public ReservationBuilder setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
        return this;
    }
    public ReservationBuilder setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
        return this;
    }
    public Reservation build() {
        Reservation reservation = new Reservation();
        reservation.setPassengerId(passenger.getId());
        reservation.setFlightId(flight.getId());
        reservation.setCheckedIn(checkedIn);
        reservation.setNumberOfBags(numberOfBags);
        return reservation;
    }
}
