package com.nagarro.controller;

import static com.nagarro.constants.ConsoleMessages.GOODBYE;
import static com.nagarro.constants.ConsoleMessages.NO_FLIGHT;
import static com.nagarro.constants.ConsoleMessages.SAME_ARR_DEP;

import java.util.List;

import com.nagarro.constants.ConsoleMessages;
import com.nagarro.inputoutput.UserInput;
import com.nagarro.inputoutput.UserOutput;
import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;
import com.nagarro.service.FlightServiceImpl;
import com.nagarro.util.CreateKeyFromInput;
import com.nagarro.util.InputValidation;

/**
 * The Class Controller.
 */
public class Controller {

	/**
	 * Start.
	 *
	 */
	public void start() {
		UserOutput.display(ConsoleMessages.WELCOME_USER);
		do {
			String userInput = UserInput.input();
			boolean isCorrectInput = InputValidation.validateInput(userInput);
			if (isCorrectInput) {
				String key = CreateKeyFromInput.generateKey(userInput);
				try {
					FlightService flightService = FlightServiceImpl
							.getInstance();
					List<Flight> flights = flightService.getSortedFlightList(
							key, userInput);
					if (flights != null) {
						UserOutput.displayFlights(flights);
					} else {
						UserOutput.display(NO_FLIGHT);
					}
				} catch (Exception exception) {
					exception.printStackTrace();
					UserOutput.display(ConsoleMessages.FILE_NOT_FOUND);
				}
			} else {
				UserOutput.display(SAME_ARR_DEP);
			}
		} while (UserInput.hasMoreQueries());
		UserOutput.display(GOODBYE);
		System.exit(0);
	}
}