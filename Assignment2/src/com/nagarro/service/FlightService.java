package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * The Interface FlightService.
 */
public interface FlightService {

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the map
	 */
	public void setList(List<Flight> map);

	/**
	 * Gets the sorted list.
	 *
	 * @param key
	 *            the key
	 * @param userInput
	 *            the user input
	 * @return the sorted list
	 */
	public List<Flight> getSortedList(String key, String userInput);

	/**
	 * Gets the valid flights.
	 *
	 * @param flights
	 *            the flights
	 * @param userInput
	 *            the user input
	 * @return the valid flights
	 */
	public List<Flight> getValidFlights(List<Flight> flights, String userInput);
}
