import java.util.List;
public class DirectFlightSearchStrategy implements FlightSearchStrategy {
private String departure;
private String arrival;
public DirectFlightSearchStrategy(String departure, String arrival) {
    this.departure = departure;
    this.arrival = arrival;
}
public List<Flight> findFlights() {
    @RequestMapping(value = "/findFlight", method = RequestMethod.POST)
	public ModelAndView findFlight(@RequestParam("departure") String departure,
			@RequestParam("arrival") String arrival,
		ModelMap modelMap) {
		List<Flight> flight = flightservie.findeFlightByDepartureDate(departure, arrival);
		modelMap.addAttribute("flights",flight);
		return new ModelAndView("displayFlights");
	}
}
