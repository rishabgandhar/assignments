package com.nagarro.inputoutput;

import com.nagarro.constants.ConsoleMessages;

/**
 * The Class CustomerOutput.
 */
public class CustomerOutput {

	/**
	 * Display bill.
	 *
	 * @param netPayableAmount
	 *            the net payable amount
	 */
	public static void displayBill(Double netPayableAmount) {
		System.out.println(ConsoleMessages.OUTPUT_MESSAGE + netPayableAmount
				+ ConsoleMessages.DOLLAR);
	}
}
