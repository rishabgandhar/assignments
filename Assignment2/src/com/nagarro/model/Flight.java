package com.nagarro.model;

import static com.nagarro.constants.NumericConstants.EQUAL_RESULT;
import static com.nagarro.constants.NumericConstants.NEGATIVE_RESULT;
import static com.nagarro.constants.NumericConstants.POSITIVE_RESULT;

import java.util.Date;

/**
 * The Class Flight.
 */
public class Flight implements Comparable<Flight> {

	/** The airline name. */
	private String airlineName;

	/** The flight number. */
	private String flightNumber;

	/** The flight departure. */
	private String flightDeparture;

	/** The flight arrival. */
	private String flightArrival;

	/** The valid till. */
	private Date validTill;

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
	 * Gets the flight name.
	 *
	 * @return the flight name
	 */
	public String getAirlineName() {
		return airlineName;
	}

	/**
	 * Sets the flight name.
	 *
	 * @param flightName
	 *            the new flight name
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
	public Date getValidTill() {
		return validTill;
	}

	/**
	 * Sets the valid till.
	 *
	 * @param validTill
	 *            the new valid till
	 */
	public void setValidTill(Date validTill) {
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

	/**
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

}
