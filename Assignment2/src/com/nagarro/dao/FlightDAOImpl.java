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

	/** The map. */
	private Map<String, List<Flight>> flightMap = new HashMap<String, List<Flight>>();

	/**
	 * @see com.nagarro.dao.FlightDAO#setList(java.util.Map)
	 */
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
				existingFlights.add(flight);
			}
		}
	}

	/**
	 * @see com.nagarro.dao.FlightDAO#getList(java.lang.String)
	 */
	@Override
	public List<Flight> getList(String key) {
		return flightMap.get(key);
	}
}
