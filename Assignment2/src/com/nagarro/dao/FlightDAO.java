package com.nagarro.dao;

import java.util.List;

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
	public void setList(List<Flight> map);

	/**
	 * Gets the list.
	 *
	 * @param key
	 *            the key
	 * @return the list
	 */
	public List<Flight> getList(String key);

}
