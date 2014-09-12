package com.nagarro.service;

import java.sql.SQLException;
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
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void setFlightMap(List<Flight> flights)
			throws ClassNotFoundException, SQLException;

	/**
	 * Gets the sorted list.
	 *
	 * @param key
	 *            the key
	 * @param userInput
	 *            the user input
	 * @return the sorted list
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Flight> getSortedList(String key, String userInput)
			throws ClassNotFoundException, SQLException;

	/**
	 * Gets the valid flights.
	 *
	 * @param flights
	 *            the flights
	 * @param userInput
	 *            the user input
	 * @return the valid flights
	 */
	public List<Flight> getValidFlightsList(List<Flight> flights,
			String userInput);
}
