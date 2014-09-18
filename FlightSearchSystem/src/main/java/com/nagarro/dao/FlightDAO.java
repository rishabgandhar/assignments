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
	 * Sets the list of flights in the map.
	 *
	 * @param flightMap
	 *            the new list
	 */
	public void setList(List<Flight> flightMap);

	/**
	 * Gets the list of flights from the map based on the key.
	 *
	 * @param key
	 *            the key
	 * @return the list
	 */
	public List<Flight> getList(String key);

}
