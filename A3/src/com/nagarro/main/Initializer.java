package com.nagarro.main;

import com.nagarro.constants.ConsoleMessages;
import com.nagarro.controller.Controller;
import com.nagarro.controller.Scheduler;
import com.nagarro.service.FlightService;
import com.nagarro.service.FlightServiceImpl;

/**
 * The Class Initializer.
 */
public class Initializer {
	
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String args[]) {
		System.out.println(ConsoleMessages.WELCOME_USER);
		FlightService flightService = new FlightServiceImpl();
		new Scheduler(flightService).readFiles();
		new Controller().start(flightService);
	}
}
