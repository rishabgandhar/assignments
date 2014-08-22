package com.nagarro.dao;

import java.util.List;
import java.util.Map;

import com.nagarro.model.Flight;

/**
 * The Interface FlightDAO.
 */
public interface FlightDAO {

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the map
	 */
	public void setMap(Map<String, List<Flight>> map);

	/**
	 * Gets the list.
	 *
	 * @param key
	 *            the key
	 * @return the list
	 */
	public List<Flight> getList(String key);

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map<String, List<Flight>> getMap();

}
