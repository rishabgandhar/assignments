package com.nagarro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.model.Flight;

/**
 * The Class FlightDAOImpl.
 */
public class FlightDAOImpl implements FlightDAO {

	/** The map. */
	private Map<String, List<Flight>> map = new HashMap<String, List<Flight>>();

	/**
	 * @see com.nagarro.dao.FlightDAO#setMap(java.util.Map)
	 */
	@Override
	public void setMap(Map<String, List<Flight>> map) {
		this.map = map;
	}

	/**
	 * @see com.nagarro.dao.FlightDAO#getList(java.lang.String)
	 */
	@Override
	public List<Flight> getList(String key) {
		return map.get(key);
	}

	/**
	 * @see com.nagarro.dao.FlightDAO#getMap()
	 */
	@Override
	public Map<String, List<Flight>> getMap() {
		return map;
	}

}
