package com.nagarro.service;

import java.util.List;

import com.nagarro.dao.FlightDAO;
import com.nagarro.dao.FlightDAOImpl;
import com.nagarro.model.Flight;

/**
 * The Class FlightServiceImpl.
 */
public class FlightServiceImpl implements FlightService {

	/** The flightdao. */
	private FlightDAO flightdao = new FlightDAOImpl();

	/** The flight service. */
	private static FlightService flightService = new FlightServiceImpl();

	/**
	 * Instantiates a new flight service impl.
	 */
	private FlightServiceImpl() {
	}

	/**
	 * Gets the single instance of FlightServiceImpl.
	 *
	 * @return single instance of FlightServiceImpl
	 */
	public static FlightService getInstance() {
		return flightService;
	}

	@Override
	public void setFlightMap(List<Flight> flights) {
		flightdao.setFlightDatabase(flights);
	}

	/**
	 * 
	 * @see com.nagarro.service.FlightService#getSortedFlightList(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public List<Flight> getSortedFlightList(String key, String userInput) {
		return flightdao.getFlightList(key, userInput);
	}

}
