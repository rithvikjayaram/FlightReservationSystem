import java.util.List;
public class FlightController {
	private static FlightController instance;
private FlightService flightService;
private FlightFactory flightFactory;
private FlightController() {
    flightService = new FlightService();
    flightFactory = new FlightFactory();
}
public static FlightController getInstance() {
    if (instance == null) {
        instance = new FlightController();
    }
    return instance;
}
public List<Flight> getAllFlights() {
    return flightService.getAllFlights();
}
public Flight findFlightById(int id) {
    return flightService.findFlightById(id);
}
public Flight addFlight(Flight flight) {
    return flightService.addFlight(flight);
}
public Flight updateFlight(Flight flight) {
    return flightService.updateFlight(flight);
}
public void deleteFlight(int id) {
    flightService.deleteFlight(id);
}
public List<Flight> findFlightByDepartureDate(String departure, String arrival) {
    flightSearchStrategy = flightFactory.createFlightSearchStrategy(departure, arrival);
    return flightSearchStrategy.findFlights();
}
}
