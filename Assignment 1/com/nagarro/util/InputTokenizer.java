package com.nagarro.util;

import java.util.StringTokenizer;

import com.nagarro.constant.Constants;

/**
 * This class tokenize the input based on a delimiter
 * 
 * @author rishabgandhar
 *
 */
public class InputTokenizer {
	/**
	 * This method tokenizes the input and throws ItemException if input is null
	 * 
	 * @param inputData
	 * @return Tokenized Data
	 * @throws ItemExceptions
	 */
	public static String[] tokenizeInput(String inputData) throws ItemExceptions {
		String tokens[] = null;
		StringTokenizer stringTokens = new StringTokenizer(inputData);
		if (stringTokens.countTokens() <= 0) {
				throw new ItemExceptions(Constants.NULL_INPUT);
			}
		tokens = new String[stringTokens.countTokens()];
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = stringTokens.nextToken();
		}
		return tokens;
	}
}
