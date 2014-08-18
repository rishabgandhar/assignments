package com.nagarro.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.constant.Constants;

/**
 * This class controls the process of asking user whether he wants to add more
 * items to the bill
 * 
 * @author rishabgandhar
 *
 */
public class AddMoreItems {
	
	static BufferedReader bufferedReader;
	/**
	 * This method asks the user whether he wants to add more items to the bill
	 * 
	 * @return true if user needs to add more item else false
	 */
	public static boolean addOtherItem() {
		boolean hasMoreItems;
		char option;
		while (true) {
			System.out.println(Constants.ASK_USER);
			option = userInput();
			if (option == Constants.YES_1 || option == Constants.YES_2) {
				hasMoreItems = true;
				break;
			} else if (option == Constants.NO_1 || option == Constants.NO_2) {
				hasMoreItems = false;
				break;
			} else {
				System.out.println(Constants.VALID_OPTION);
			}
		}
		return hasMoreItems;
	}

	/**
	 * This method returns the character entered by the user
	 * 
	 * @return char y or n
	 */
	public static char userInput() {
		char userOption = Constants.NO_1;
		bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			userOption = (char) bufferedReader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userOption;
	}
	/**
	 * This method is overriden and closes the bufferedReader connected to Keyboard
	 */
	@Override
	protected void finalize() throws Throwable {
		bufferedReader.close();
	}
}
