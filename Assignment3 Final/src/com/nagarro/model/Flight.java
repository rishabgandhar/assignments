package com.nagarro.model;

import static com.nagarro.constants.GenericConstants.YES_OPTION;
import static com.nagarro.constants.NumericConstants.EQUAL_RESULT;
import static com.nagarro.constants.NumericConstants.NEGATIVE_RESULT;
import static com.nagarro.constants.NumericConstants.POSITIVE_RESULT;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.constants.CSVReaderConstants;

/**
 * The Class Flight.
 */
@SuppressWarnings("serial")
public class Flight implements Comparable<Flight>, Serializable {

	/**
	 * Instantiates a new flight.
	 */
	public Flight() {
	}

	/** The flight id. */
	private int flightId;

	/** The airline name. */
	private String airlineName;

	/** The flight number. */
	private String flightNumber;

	/** The flight departure. */
	private String flightDeparture;

	/** The flight arrival. */
	private String flightArrival;

	/** The valid till. */
	private java.sql.Date validTill;

	/** The flight time. */
	private String flightTime;

	/** The flight duration. */
	private Double flightDuration;

	/** The flight fare. */
	private Double flightFare;

	/** The flight availability. */
	private Boolean flightAvailability;

	/** The flight class. */
	private String flightClass;

	/**
	 * Gets the airline name.
	 *
	 * @return the airline name
	 */
	public String getAirlineName() {
		return airlineName;
	}

	/**
	 * Sets the airline name.
	 *
	 * @param flightName
	 *            the new airline name
	 */
	public void setAirlineName(String flightName) {
		this.airlineName = flightName;
	}

	/**
	 * Gets the flight number.
	 *
	 * @return the flight number
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * Sets the flight number.
	 *
	 * @param flightNumber
	 *            the new flight number
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * Gets the flight departure.
	 *
	 * @return the flight departure
	 */
	public String getFlightDeparture() {
		return flightDeparture;
	}

	/**
	 * Sets the flight departure.
	 *
	 * @param flightDeparture
	 *            the new flight departure
	 */
	public void setFlightDeparture(String flightDeparture) {
		this.flightDeparture = flightDeparture;
	}

	/**
	 * Gets the flight arrival.
	 *
	 * @return the flight arrival
	 */
	public String getFlightArrival() {
		return flightArrival;
	}

	/**
	 * Sets the flight arrival.
	 *
	 * @param flightArrival
	 *            the new flight arrival
	 */
	public void setFlightArrival(String flightArrival) {
		this.flightArrival = flightArrival;
	}

	/**
	 * Gets the valid till.
	 *
	 * @return the valid till
	 */
	public java.sql.Date getValidTill() {
		return validTill;
	}

	/**
	 * Sets the valid till.
	 *
	 * @param validTill
	 *            the new valid till
	 */
	public void setValidTill(java.sql.Date validTill) {
		this.validTill = validTill;
	}

	/**
	 * Gets the flight time.
	 *
	 * @return the flight time
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * Sets the flight time.
	 *
	 * @param flightTime
	 *            the new flight time
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	/**
	 * Gets the flight duration.
	 *
	 * @return the flight duration
	 */
	public Double getFlightDuration() {
		return flightDuration;
	}

	/**
	 * Sets the flight duration.
	 *
	 * @param flightDuration
	 *            the new flight duration
	 */
	public void setFlightDuration(Double flightDuration) {
		this.flightDuration = flightDuration;
	}

	/**
	 * Gets the flight fare.
	 *
	 * @return the flight fare
	 */
	public Double getFlightFare() {
		return flightFare;
	}

	/**
	 * Sets the flight fare.
	 *
	 * @param flightFare
	 *            the new flight fare
	 */
	public void setFlightFare(Double flightFare) {
		this.flightFare = flightFare;
	}

	/**
	 * Gets the flight availability.
	 *
	 * @return the flight availability
	 */
	public Boolean getFlightAvailability() {
		return flightAvailability;
	}

	/**
	 * Sets the flight availability.
	 *
	 * @param flightAvailability
	 *            the new flight availability
	 */
	public void setFlightAvailability(Boolean flightAvailability) {
		this.flightAvailability = flightAvailability;
	}

	/**
	 * Gets the flight class.
	 *
	 * @return the flight class
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * Sets the flight class.
	 *
	 * @param flightClass
	 *            the new flight class
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Flight o) {
		int difference = EQUAL_RESULT;
		double diff = this.getFlightFare() - o.getFlightFare();
		if (diff > EQUAL_RESULT) {
			difference = POSITIVE_RESULT;
		} else if (diff == EQUAL_RESULT) {
			difference = EQUAL_RESULT;
		} else {
			difference = NEGATIVE_RESULT;
		}
		return difference;
	}

	/**
	 * Gets the single instance of Flight.
	 *
	 * @param data
	 *            the data
	 * @param type
	 *            the type
	 * @return single instance of Flight
	 */
	public static Flight getInstance(String data[], String type) {
		Flight flight = new Flight();
		flight.setFlightNumber(data[0]);
		flight.setFlightDeparture(data[1]);
		flight.setFlightArrival(data[2]);
		if (type.equalsIgnoreCase("sql")) {
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data[3]);
				flight.setValidTill(new java.sql.Date(date.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Date date = new SimpleDateFormat(CSVReaderConstants.DATE_FORMAT)
						.parse(data[3]);
				flight.setValidTill(new java.sql.Date(date.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		flight.setFlightTime(data[4]);
		flight.setFlightDuration(Double.parseDouble(data[5]));
		flight.setFlightFare(Double.parseDouble(data[6]));
		flight.setFlightClass(data[8]);
		if (data[7].equalsIgnoreCase(YES_OPTION)) {
			flight.setFlightAvailability(true);
		} else {
			flight.setFlightAvailability(false);
		}
		flight.setAirlineName(data[9]);
		return flight;
	}

	/**
	 * Gets the flight id.
	 *
	 * @return the flight id
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * Sets the flight id.
	 *
	 * @param flightId
	 *            the new flight id
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

}
