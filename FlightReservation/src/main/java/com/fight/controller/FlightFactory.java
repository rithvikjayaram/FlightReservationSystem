public class FlightFactory {
	public FlightSearchStrategy createFlightSearchStrategy(String departure, String arrival) {
		if (departure.equals(departure_city) && arrival.equals(arrival_city)) {
        return new DirectFlightSearchStrategy(departure, arrival);
		} 
		else {
	        return new ConnectingFlightSearchStrategy(departure, arrival);
	    }
}
}
