package com.nagarro.util;

import java.text.ParseException;

import com.nagarro.constants.CSVReaderConstants;
import com.nagarro.constants.ConsoleMessages;
import com.nagarro.constants.GenericConstants;

public class FlightDataValidation {

	/**
	 * Valid flight data.
	 *
	 * @param airline
	 *            the airline
	 * @param rowNo
	 *            the row no
	 * @param airlineName
	 *            the airline name
	 * @return true, if successful
	 * @throws Exception
	 *             the exception
	 */
	public static boolean validFlightData(String airline[], int rowNo,
			String airlineName) throws Exception {
		boolean isValid = true;
		if (airline[0].length() != 5) {
			isValid = false;
		}
		if (airline[1].length() != 3 && airline[2].length() != 3) {
			isValid = false;
		}
		try {
			DateParser.parseDate(airline[3]);
		} catch (ParseException e) {
			isValid = false;
			e.printStackTrace();
		}
		try {
			Double.parseDouble(airline[5]);
			Double.parseDouble(airline[6]);
		} catch (NumberFormatException e) {
			isValid = false;
			e.printStackTrace();
		}
		if (!(airline[7].contains(GenericConstants.YES_OPTION) || airline[7]
				.contains(GenericConstants.NO_OPTION))) {
			isValid = false;
		}
		if (!(airline[8].contains(CSVReaderConstants.BUSINESS) || airline[8]
				.contains(CSVReaderConstants.ECONOMIC))) {
			isValid = false;
		}
		if (!isValid) {
			throw new Exception(ConsoleMessages.INVAILD_FLIGHT_DETAILS + rowNo
					+ " in " + airlineName);
		}
		return isValid;
	}
}
