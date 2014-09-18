package com.nagarro.inputoutput;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * The Class UserOutput that shows the list of available Flights to the user.
 */
public class UserOutput {

	/**
	 * Display the message.
	 *
	 * @param message
	 *            the message
	 */
	public static void display(String message) {
		System.out.println(message);
	}

	/**
	 * Display list of flights.
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
			System.out.format("%-20s", flights.get(index).getFlightTime());
			System.out.format("%-20s", flights.get(index).getFlightDuration());
			System.out.format("%-20s\n",
					Math.round(flights.get(index).getFlightFare()));
		}
		System.out
				.println("-----------------------------------------------------------------------------------------");
		System.out.println();
	}
}
