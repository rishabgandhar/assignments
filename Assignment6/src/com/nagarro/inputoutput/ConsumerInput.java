package com.nagarro.inputoutput;

import com.nagarro.util.ConsoleInput;


/**
 * The Class ConsumerInput.
 */
public class ConsumerInput {

	/**
	 * Gets the consumer choice.
	 *
	 * @return the consumer choice
	 */
	public static String getConsumerChoice() {
		String consumerChoice = ConsoleInput.getGarmentName();
		return consumerChoice;
	}
}
