package com.nagarro.util;

import static com.nagarro.constants.NumericConstants.EQUAL_RESULT;
import static com.nagarro.constants.NumericConstants.NEGATIVE_RESULT;
import static com.nagarro.constants.NumericConstants.POSITIVE_RESULT;

import java.util.Comparator;

import com.nagarro.model.Flight;

/**
 * The Class SortByDurationAndFare.
 */
public class SortByDurationAndFare implements Comparator<Flight> {

	/**
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Flight o1, Flight o2) {
		int difference = EQUAL_RESULT;
		double diff = o1.getFlightDuration() - o2.getFlightDuration();
		if (diff == EQUAL_RESULT) {
			diff = o1.getFlightFare() - o2.getFlightFare();
		}
		if (diff > EQUAL_RESULT) {
			difference = POSITIVE_RESULT;
		} else if (diff == EQUAL_RESULT) {
			difference = EQUAL_RESULT;
		} else {
			difference = NEGATIVE_RESULT;
		}
		return difference;
	}
}
