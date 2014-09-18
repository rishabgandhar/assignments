package com.nagarro.util;

import static com.nagarro.constants.CSVReaderConstants.DELIMITER;
import static com.nagarro.constants.NumericConstants.KEY_LENGTH;

import com.nagarro.constants.GenericConstants;

/**
 * The Class CreateKeyFromInput generates the key from user Input.
 */
public class CreateKeyFromInput {

	/**
	 * Generates key from user input.
	 *
	 * @param userInput
	 *            the user input
	 * @return the key
	 */
	public static String generateKey(String userInput) {
		String tokens[] = userInput.split(DELIMITER);
		String key = GenericConstants.INITIALIZE_STRING;
		for (int index = 0; index < KEY_LENGTH; index++) {
			key += tokens[index].toUpperCase();
			if (index != KEY_LENGTH - 1) {
				key += DELIMITER;
			}
		}
		return key;
	}
}
