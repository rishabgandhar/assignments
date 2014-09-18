package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * This interface defines the standards for a class to implement itself as a
 * Flight Data Access Object
 * 
 * @author rishabgandhar
 *
 */
public interface FlightDAO {

	/**
	 * Sets the list of flights in the flight database.
	 *
	 * @param flights
	 *            the new flight database
	 */
	public void setFlightDatabase(List<Flight> flights);

	/**
	 * Gets the flight list from database based on the key.
	 *
	 * @param key
	 *            the key
	 * @param userInput
	 *            the user input
	 * @return the flight list
	 */
	public List<Flight> getFlightList(String key, String userInput);

}
