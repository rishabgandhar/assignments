package com.nagarro.inputoutput;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * The Class UserOutput.
 * 
 * @author rishabgandhar
 * 
 */
public class UserOutput {

	/**
	 * Display.
	 *
	 * @param message
	 *            the message
	 */
	public static void display(String message) {
		System.out.println(message);
	}

	/**
	 * Display flights.
	 *
	 * @param flights
	 *            the flights
	 */
	public static void displayFlights(List<Flight> flights) {
		System.out.format("%-20s", "Flight Name");
		System.out.format("%-20s", "Flight Number");
		System.out.format("%-20s", "Flight Time");
		System.out.format("%-20s", "Flight Duration");
		System.out.format("%-20s\n", "Flight Fare");
		System.out
				.println("-----------------------------------------------------------------------------------------");
		for (int index = 0; index < flights.size(); index++) {
			System.out.format("%-20s", flights.get(index).getAirlineName());
			System.out.format("%-20s", flights.get(index).getFlightNumber());
			System.out.format(
					"%-20s",
					flights.get(index)
							.getFlightTime()
							.substring(
									flights.get(index).getFlightTime()
											.indexOf(":") + 1));
			System.out.format("%-20s", flights.get(index).getFlightDuration());
			System.out.format("%-20s\n",
					Math.round(flights.get(index).getFlightFare()));
		}
		System.out
				.println("-----------------------------------------------------------------------------------------");
		System.out.println();
	}
}
