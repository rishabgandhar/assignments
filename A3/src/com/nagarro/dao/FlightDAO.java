package com.nagarro.dao;

import java.sql.SQLException;
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
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void setFlightMap(List<Flight> flight)
			throws ClassNotFoundException, SQLException;

	/**
	 * Gets the list.
	 *
	 * @param key
	 *            the key
	 * @return the list
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Flight> getList(String key) throws ClassNotFoundException,
			SQLException;

}
