package com.nagarro.inputoutput;

import static com.nagarro.constants.CSVReaderConstants.DELIMITER;

import com.nagarro.constants.GenericConstants;
import com.nagarro.util.ConsoleInput;

/**
 * The Class UserInput.
 */
public class UserInput {

	/**
	 * Input.
	 *
	 * @return the string
	 */
	public static String input() {
		String departureStation = ConsoleInput.getDepStn();
		String arrivalStation = ConsoleInput.getArrStn();
		String flightDate = ConsoleInput.getJourneyDate();
		String flightClass = ConsoleInput.getFlightClass();
		String sortOption = ConsoleInput.getSortOption();
		String finalInputString = departureStation + DELIMITER + arrivalStation
				+ DELIMITER + flightClass + DELIMITER + flightDate + DELIMITER
				+ sortOption;
		return finalInputString;
	}

	/**
	 * Checks for more queries.
	 *
	 * @return true, if successful
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
