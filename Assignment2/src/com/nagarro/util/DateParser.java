package com.nagarro.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.constants.CSVReaderConstants;

public class DateParser {

	public static Date parseDate(String date) throws ParseException {
		DateFormat formatter;
		formatter = new SimpleDateFormat(CSVReaderConstants.DATE_FORMAT);
		return formatter.parse(date);
	}
}
