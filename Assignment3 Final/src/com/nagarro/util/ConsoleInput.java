package com.nagarro.util;

import static com.nagarro.constants.ConsoleMessages.WRONG_OPTION;
import static com.nagarro.constants.GenericConstants.INITIALIZE_STRING;
import static com.nagarro.constants.GenericConstants.NO_OPTION;
import static com.nagarro.constants.GenericConstants.YES_OPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.constants.ConsoleMessages;


/**
 * The Class ConsoleInput.
 */
public class ConsoleInput {

	/**
	 * Input data.
	 *
	 * @return the string
	 */
	private static String inputData() {
		BufferedReader bufferedreader = new BufferedReader(
				new InputStreamReader(System.in));
		String userInput = INITIALIZE_STRING;
		try {
			userInput = bufferedreader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInput;
	}

	/**
	 * Gets the dep stn.
	 *
	 * @return the dep stn
	 */
	public static String getDepStn() {
		String depStn = INITIALIZE_STRING;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_DEP_STN);
			depStn = inputData();
			try {
				if (InputValidation.validateStationName(depStn)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return depStn;
	}

	/**
	 * Gets the arr stn.
	 *
	 * @return the arr stn
	 */
	public static String getArrStn() {
		String arrStn = INITIALIZE_STRING;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_ARR_STN);
			arrStn = inputData();
			try {
				if (InputValidation.validateStationName(arrStn)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arrStn;
	}

	/**
	 * Gets the flight class.
	 *
	 * @return the flight class
	 */
	public static String getFlightClass() {
		String flightClass = INITIALIZE_STRING;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_FLIGHT_CLASS);
			flightClass = inputData();
			try {
				if (InputValidation.validateFlightClass(flightClass)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flightClass;
	}

	/**
	 * Gets the sort option.
	 *
	 * @return the sort option
	 */
	public static String getSortOption() {
		String sortOption = INITIALIZE_STRING;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_SORT_OPTION);
			sortOption = inputData();
			try {
				if (InputValidation.validateSortOption(sortOption)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sortOption;
	}

	/**
	 * Gets the journey date.
	 *
	 * @return the journey date
	 */
	public static String getJourneyDate() {
		String date = INITIALIZE_STRING;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_FLIGHT_DATE);
			date = inputData();
			try {
				if (InputValidation.validateDateFormat(date)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	/**
	 * Gets the user option.
	 *
	 * @return the user option
	 */
	public static String getUserOption() {
		String option = INITIALIZE_STRING;
		while(true) {
			System.out.println(ConsoleMessages.ASK_OTHER_QUERY);
			option = inputData();
			if (option.equalsIgnoreCase(YES_OPTION)
					|| option.equalsIgnoreCase(NO_OPTION)) {
				break;
			} else {
				System.out.println(WRONG_OPTION);
			}
		}
		return option;
	}
}
