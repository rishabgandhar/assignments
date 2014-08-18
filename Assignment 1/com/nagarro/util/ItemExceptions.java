package com.nagarro.util;

/**
 * This class acts as an exception class and displays the message passed to it
 * 
 * @author rishabgandhar
 *
 */
@SuppressWarnings("serial")
public class ItemExceptions extends Exception {

	String exceptionName;
	public ItemExceptions(String exception) {
		exceptionName = exception;
	}

	@Override
	public String getMessage() {
		return exceptionName;
	}

	@Override
	public void printStackTrace() {
		System.out.println(exceptionName);
	}
}
