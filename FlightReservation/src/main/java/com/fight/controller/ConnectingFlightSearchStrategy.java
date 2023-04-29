public class ConnectingFlightSearchStrategy implements FlightSearchStrategy {

    private AirportService airportService;
    private FlightService flightService;

    public ConnectingFlightSearchStrategy(AirportService airportService, FlightService flightService) {
        this.airportService = airportService;
        this.flightService = flightService;
    }

    @Override
    public List<Flight> findFlights(String departure, String arrival) {
        List<Airport> connectingAirports = airportService.getConnectingAirports(departure, arrival);
        List<Flight> flights = new ArrayList<>();
        for (Airport connectingAirport : connectingAirports) {
            List<Flight> firstLegFlights = flightService.findFlightsByDepartureAndArrival(departure, connectingAirport.getName());
            List<Flight> secondLegFlights = flightService.findFlightsByDepartureAndArrival(connectingAirport.getName(), arrival);
            for (Flight firstLegFlight : firstLegFlights) {
                for (Flight secondLegFlight : secondLegFlights) {
                    if (firstLegFlight.getArrivalDate().plusHours(2).isBefore(secondLegFlight.getDepartureDate())) {
                        flights.add(new Flight(firstLegFlight, secondLegFlight));
                    }
                }
            }
        }
        return flights;
    }
}