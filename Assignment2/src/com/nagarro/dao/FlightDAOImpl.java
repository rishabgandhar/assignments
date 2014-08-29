package com.nagarro.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.constants.CSVReaderConstants;
import com.nagarro.model.Flight;

/**
 * The Class FlightDAOImpl.
 */
public class FlightDAOImpl implements FlightDAO {

	/** The flight map. */
	private Map<String, List<Flight>> flightMap = new HashMap<String, List<Flight>>();

	@Override
	public void setList(List<Flight> flights) {
		for (Flight flight : flights) {
			String key = flight.getFlightDeparture()
					+ CSVReaderConstants.DELIMITER + flight.getFlightArrival()
					+ CSVReaderConstants.DELIMITER + flight.getFlightClass();
			List<Flight> existingFlights = flightMap.get(key);
			if (existingFlights == null) {
				existingFlights = new ArrayList<>();
				existingFlights.add(flight);
				flightMap.put(key, existingFlights);
			} else {
				if (notExists(flight, existingFlights)) {
					existingFlights.add(flight);
				}
			}
		}
	}

	private boolean notExists(Flight flight, List<Flight> existingFlights) {
		boolean existingFlight = false;
		for (Flight currentFlight : existingFlights) {
			if (currentFlight.getFlightNumber().equalsIgnoreCase(
					flight.getFlightNumber())
					&& currentFlight.getFlightTime().equalsIgnoreCase(
							flight.getFlightTime())
					&& currentFlight.getFlightClass().equalsIgnoreCase(
							flight.getFlightClass())) {
				existingFlight = true;
			}
		}
		return existingFlight;
	}

	@Override
	public List<Flight> getList(String key) {
		return flightMap.get(key);
	}
}
