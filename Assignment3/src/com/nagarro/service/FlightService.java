package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * This interface defines the standards for a class to implement itself as an
 * Flight Service implementing business logic
 * 
 * @author rishabgandhar
 *
 */
public interface FlightService {

	/**
	 * Sets the list of flights to the flight map.
	 *
	 * @param flights
	 *            the list of flights
	 */
	public void setFlightMap(List<Flight> flights);

	/**
	 * Gets the sorted list of flights from the flight Map based on the key.
	 *
	 * @param key
	 *            the key
	 * @param userInput
	 *            the user input
	 * @return the sorted list
	 */
	public List<Flight> getSortedFlightList(String key, String userInput);

}
