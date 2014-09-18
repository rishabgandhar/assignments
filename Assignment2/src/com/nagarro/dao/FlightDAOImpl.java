package com.nagarro.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nagarro.constants.CSVReaderConstants;
import com.nagarro.model.Flight;

/**
 * This class is an implementation of FlightDAO and acts as a Data Access Object
 * class
 * 
 * @author rishabgandhar
 *
 */
public class FlightDAOImpl implements FlightDAO {

	/** The flight map. */
	private Map<String, List<Flight>> flightMap = new ConcurrentHashMap<String, List<Flight>>();

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
				if (!exists(flight, existingFlights)) {
					existingFlights.add(flight);
				} else {
					System.out.println("Flight Already Exists in Database");
				}
			}
		}
	}

	/**
	 * Returns True if a flight exists in a list of Existing Flights
	 *
	 * @param flight
	 *            the flight
	 * @param existingFlights
	 *            the existing flights
	 * @return true, if successful
	 */
	private boolean exists(Flight flight, List<Flight> existingFlights) {
		boolean isExists = false;
		for (Flight currentFlight : existingFlights) {
			if (currentFlight.getFlightNumber().equalsIgnoreCase(
					flight.getFlightNumber())
					&& currentFlight.getFlightTime().equalsIgnoreCase(
							flight.getFlightTime())
					&& currentFlight.getFlightClass().equalsIgnoreCase(
							flight.getFlightClass())) {
				isExists = true;
				break;
			}
		}
		return isExists;
	}

	@Override
	public List<Flight> getList(String key) {
		return flightMap.get(key);
	}
}
