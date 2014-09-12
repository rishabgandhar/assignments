package com.nagarro.controller;

import com.nagarro.inputoutput.ConsumerInput;
import com.nagarro.model.Garment;
import com.nagarro.util.ConsoleOutput;
import com.nagarro.util.GarmentFactory;

/**
 * The Class Controller.
 */
public class Controller {

	/**
	 * Start.
	 */
	public void start() {
		try {
			String consumerChoice = ConsumerInput.getConsumerChoice();
			Garment garment = GarmentFactory.getInstance(consumerChoice);
			garment.print();
		} catch (Exception exception) {
			ConsoleOutput.display(exception.getMessage());
		}
	}
}
