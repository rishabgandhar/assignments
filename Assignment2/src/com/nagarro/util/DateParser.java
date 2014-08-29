package com.nagarro.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.constants.CSVReaderConstants;

/**
 * The Class DateParser.
 */
public class DateParser {

	/**
	 * Parses the date.
	 *
	 * @param date
	 *            the date
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Date parseDate(String date) throws ParseException {
		DateFormat formatter;
		formatter = new SimpleDateFormat(CSVReaderConstants.DATE_FORMAT);
		return formatter.parse(date);
	}
}
