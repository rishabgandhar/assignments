package com.nagarro.main;

import com.nagarro.controller.Controller;
import com.nagarro.controller.Scheduler;

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
		new Scheduler().readFiles();
		new Controller().start();
	}
}
