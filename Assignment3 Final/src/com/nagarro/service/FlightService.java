package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * The Interface FlightService.
 */
public interface FlightService {

	/**
	 * Sets the flight map.
	 *
	 * @param flights
	 *            the list of flights
	 */
	public void setFlightMap(List<Flight> flights);

	/**
	 * Gets the sorted list.
	 *
	 * @param key
	 *            the key
	 * @param userInput
	 *            the user input
	 * @return the sorted list
	 */
	public List<Flight> getSortedFlightList(String key, String userInput);
			
}
