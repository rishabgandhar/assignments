package com.nagarro.service;

import static com.nagarro.constants.StringConstants.DATE_FORMAT;
import static com.nagarro.constants.StringConstants.DELIMITER;
import static com.nagarro.constants.StringConstants.OPTION_A;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.nagarro.dao.FlightDAO;
import com.nagarro.dao.FlightDAOImpl;
import com.nagarro.model.Flight;
import com.nagarro.util.SortByDurationAndFare;

/**
 * The Class FlightServiceImpl.
 */
public class FlightServiceImpl implements FlightService {

	/** The flightdao. */
	private FlightDAO flightdao = new FlightDAOImpl();

	/**
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see com.nagarro.service.FlightService#setFlightMap(java.util.Map)
	 */
	@Override
	public void setFlightMap(List<Flight> flights)
			throws ClassNotFoundException, SQLException {
		flightdao.setFlightMap(flights);
	}

	/**
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see com.nagarro.service.FlightService#getSortedList(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public List<Flight> getSortedList(String key, String userInput)
			throws ClassNotFoundException, SQLException {
		String option = userInput
				.substring(userInput.lastIndexOf(DELIMITER) + 1);
		List<Flight> flights = flightdao.getList(key);
		if (flights != null) {
			flights = getValidFlightsList(flights, userInput);
			if (option.equalsIgnoreCase(OPTION_A)) {
				Collections.sort(flights);
			} else {
				Collections.sort(flights, new SortByDurationAndFare());
			}
		}
		return flights;
	}

	/**
	 * @see com.nagarro.service.FlightService#getValidFlights(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public List<Flight> getValidFlightsList(List<Flight> flights,
			String userInput) {
		int index = userInput.lastIndexOf(DELIMITER);
		int index2 = userInput.lastIndexOf(DELIMITER, index - 1);
		String inputDate = userInput.substring(index2 + 1, index);
		java.sql.Date sqlDate;
		try {
			Date date = new SimpleDateFormat(DATE_FORMAT).parse(inputDate);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			sqlDate = null;
		}
		List<Flight> validFlights = new ArrayList<Flight>();
		for (Flight flight : flights) {
			java.sql.Date validDate = new java.sql.Date(flight.getValidTill()
					.getTime());
			if (validDate.compareTo(sqlDate) >= 0) {
				validFlights.add(flight);
			}
		}
		return validFlights;
	}
}
