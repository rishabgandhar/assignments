package com.nagarro.util;

import static com.nagarro.constants.ConsoleMessages.WRONG_CLASS;
import static com.nagarro.constants.ConsoleMessages.WRONG_DATE;
import static com.nagarro.constants.ConsoleMessages.WRONG_DEP_STN;
import static com.nagarro.constants.ConsoleMessages.WRONG_SORT_OPTN;
import static com.nagarro.constants.NumericConstants.STN_NAME_LENGTH;
import static com.nagarro.constants.StringConstants.BUSINESS;
import static com.nagarro.constants.StringConstants.DATE_FORMAT;
import static com.nagarro.constants.StringConstants.DELIMITER;
import static com.nagarro.constants.StringConstants.ECONOMIC;
import static com.nagarro.constants.StringConstants.OPTION_A;
import static com.nagarro.constants.StringConstants.OPTION_B;
import static com.nagarro.constants.StringConstants.STN_NAME_EXPR;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The Class InputValidation.
 */
public class InputValidation {

	/**
	 * Validate station name.
	 *
	 * @param stnName
	 *            the stn name
	 * @return true, if successful
	 */
	public static boolean validateStationName(String stnName) {
		boolean isValid;
		if (stnName == null) {
			System.out.println(WRONG_DEP_STN);
			isValid = false;
		} else if (stnName.length() != STN_NAME_LENGTH) {
			System.out.println(WRONG_DEP_STN);
			isValid = false;
		} else if (!stnName.matches(STN_NAME_EXPR)) {
			System.out.println(WRONG_DEP_STN);
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Validate date format.
	 *
	 * @param date
	 *            the date
	 * @return true, if successful
	 */
	public static boolean validateDateFormat(String date) {
		boolean isValid;
		try {
			DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			formatter.setLenient(false);
			formatter.parse(date);
			isValid = true;
		} catch (ParseException e) {
			System.out.println(WRONG_DATE);
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Validate flight class.
	 *
	 * @param flightClass
	 *            the flight class
	 * @return true, if successful
	 */
	public static boolean validateFlightClass(String flightClass) {
		boolean isValid;
		if (flightClass.equalsIgnoreCase(ECONOMIC)
				|| flightClass.equalsIgnoreCase(BUSINESS)) {
			isValid = true;
		} else {
			System.out.println(WRONG_CLASS);
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Validate sort option.
	 *
	 * @param sortOption
	 *            the sort option
	 * @return true, if successful
	 */
	public static boolean validateSortOption(String sortOption) {
		boolean isValid;
		if (sortOption.equalsIgnoreCase(OPTION_A)
				|| sortOption.equalsIgnoreCase(OPTION_B)) {
			isValid = true;
		} else {
			System.out.println(WRONG_SORT_OPTN);
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Validate input.
	 *
	 * @param userInput
	 *            the user input
	 * @return true, if successful
	 */
	public static boolean validateInput(String userInput) {
		boolean isValid;
		String depStn = userInput.substring(0, userInput.indexOf(DELIMITER));
		String arrStn = userInput.substring(userInput.indexOf(DELIMITER) + 1,
				userInput.indexOf(DELIMITER, userInput.indexOf(DELIMITER) + 1));
		if (depStn.equals(arrStn)) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}

}
