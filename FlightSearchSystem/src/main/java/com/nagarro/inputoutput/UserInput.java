package com.nagarro.inputoutput;

import static com.nagarro.constants.CSVReaderConstants.DELIMITER;

import com.nagarro.constants.GenericConstants;
import com.nagarro.util.ConsoleInput;

/**
 * The Class UserInput takes Input regarding flights from the User.
 */
public class UserInput {

	/**
	 * Takes the Input From The User.
	 *
	 * @return the input string
	 */
	public static String input() {
		String departureStation = ConsoleInput.getDepartureStation();
		String arrivalStation = ConsoleInput.getArrivalStation();
		String flightDate = ConsoleInput.getJourneyDate();
		String flightClass = ConsoleInput.getFlightClass();
		String sortOption = ConsoleInput.getSortingOption();
		String finalInputString = departureStation + DELIMITER + arrivalStation
				+ DELIMITER + flightClass + DELIMITER + flightDate + DELIMITER
				+ sortOption;
		return finalInputString;
	}

	/**
	 * Checks for more queries.
	 *
	 * @return true, if more queries
	 */
	public static boolean hasMoreQueries() {
		boolean status;
		String option = ConsoleInput.getUserOption();
		if (option.equalsIgnoreCase(GenericConstants.YES_OPTION)) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}
}
