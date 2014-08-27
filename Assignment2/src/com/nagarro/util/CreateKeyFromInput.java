package com.nagarro.util;

import static com.nagarro.constants.CSVReaderConstants.DELIMITER;
import static com.nagarro.constants.NumericConstants.KEY_LENGTH;

import com.nagarro.constants.GenericConstants;

/**
 * The Class CreateKeyFromInput.
 */
public class CreateKeyFromInput {

	/**
	 * Generate key.
	 *
	 * @param userInput
	 *            the user input
	 * @return the string
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
