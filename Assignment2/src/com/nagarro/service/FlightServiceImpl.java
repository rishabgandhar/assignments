package com.nagarro.service;

import static com.nagarro.constants.StringConstants.DATE_FORMAT;
import static com.nagarro.constants.StringConstants.DELIMITER;
import static com.nagarro.constants.StringConstants.OPTION_A;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	 * @see com.nagarro.service.FlightService#setMap(java.util.Map)
	 */
	@Override
	public void setMap(Map<String, List<Flight>> map) {
		flightdao.setMap(map);
	}

	/**
	 * 
	 * @see com.nagarro.service.FlightService#getSortedList(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public List<Flight> getSortedList(String key, String userInput) {
		String option = userInput
				.substring(userInput.lastIndexOf(DELIMITER) + 1);
		List<Flight> flights = flightdao.getList(key);
		if (flights != null) {
			flights = getValidFlights(flights, userInput);
			if (option.equalsIgnoreCase(OPTION_A)) {
				Collections.sort(flights);
			} else {
				Collections.sort(flights, new SortByDurationAndFare());
			}
		}
		return flights;
	}

	/**
	 * @see com.nagarro.service.FlightService#getMap()
	 */
	@Override
	public Map<String, List<Flight>> getMap() {
		return flightdao.getMap();
	}

	/**
	 * @see com.nagarro.service.FlightService#getValidFlights(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public List<Flight> getValidFlights(List<Flight> flights, String userInput) {
		int index = userInput.lastIndexOf(DELIMITER);
		int index2 = userInput.lastIndexOf(DELIMITER, index - 1);
		String inputDate = userInput.substring(index2 + 1, index);
		Date date;
		try {
			DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			date = formatter.parse(inputDate);
		} catch (ParseException e) {
			date = null;
			e.printStackTrace();
		}
		List<Flight> validFlights = new ArrayList<Flight>();
		for (Flight flight : flights) {
			if ((flight.getValidTill().after(date) || flight.getValidTill()
					.equals(date)) && flight.getFlightAvailability()) {
				validFlights.add(flight);
			}
		}
		return validFlights;
	}
}