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
	 * @param flightMap
	 *            the new list
	 */
	public void setList(List<Flight> flightMap);

	/**
	 * Gets the sorted list of flights from the flight Map based on the key.
	 *
	 * @param key
	 *            the key
	 * @param userInput
	 *            the user input
	 * @return the sorted list
	 */
	public List<Flight> getSortedList(String key, String userInput);

	/**
	 * Gets the list of valid flights based on validity date and availability.
	 *
	 * @param flights
	 *            the flights
	 * @param userInput
	 *            the user input
	 * @return the valid flights
	 */
	public List<Flight> getValidFlights(List<Flight> flights, String userInput);
}
