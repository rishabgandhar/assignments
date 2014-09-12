package com.nagarro.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.constants.ConsoleMessages;

/**
 * The Class ConsoleInput.
 */
public class ConsoleInput {

	/**
	 * Gets the garment name.
	 *
	 * @return the garment name
	 */
	public static String getGarmentName() {
		String garmentName = null;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_GARMENT_NAME);
			garmentName = inputData();
			try {
				if (InputValidation.validateGarmentName(garmentName)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(ConsoleMessages.VALID_OPTION);
		}
		return garmentName;
	}

	/**
	 * Input data.
	 *
	 * @return the string
	 */
	private static String inputData() {
		BufferedReader bufferedreader = new BufferedReader(
				new InputStreamReader(System.in));
		String userInput = null;
		try {
			userInput = bufferedreader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInput;
	}

}
