package com.nagarro.inputoutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.constant.Constants;


/**
 * This class takes the input of the item from the user
 * 
 * @author rishabgandhar
 *
 */
public class UserInput {
	private static BufferedReader bufferedReader;
	
	/**
	 * This method takes the input from the user and returns that input
	 * 
	 * @return String input
	 */
	public static String input() {
		System.out.println(Constants.ENTER_DETAILS);
		return inputData();
	}

	public static String inputData() {
		String inputData = Constants.INITIALIZE_STRING;
		bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			inputData = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputData;
	}
	
	/**
	 * This method is overriden and closes the bufferedReader connected to Keyboard
	 */
	@Override
	protected void finalize() throws Throwable {
		bufferedReader.close();
	}
}
