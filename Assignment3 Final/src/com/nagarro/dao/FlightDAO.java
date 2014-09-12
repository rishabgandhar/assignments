package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * The Interface FlightDAO.
 */
public interface FlightDAO {

	/**
	 * Sets the flight database.
	 *
	 * @param flights
	 *            the new flight database
	 */
	public void setFlightDatabase(List<Flight> flights);

	/**
	 * Gets the flight list.
	 *
	 * @param key
	 *            the key
	 * @param userInput
	 *            the user input
	 * @return the flight list
	 */
	public List<Flight> getFlightList(String key, String userInput);

}
