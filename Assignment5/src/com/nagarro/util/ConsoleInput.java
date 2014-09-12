package com.nagarro.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.constants.ConsoleMessages;
import com.nagarro.constants.DiscountConstants;
import com.nagarro.constants.GenericConstants;

/**
 * The Class ConsoleInput.
 */
public class ConsoleInput {

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public static String getItemName() {
		String itemName = null;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_ITEM_NAME);
			itemName = inputData();
			try {
				if (InputValidation.validateItemName(itemName)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemName;
	}

	/**
	 * Gets the item price.
	 *
	 * @return the item price
	 */
	public static String getItemPrice() {
		String itemPrice = null;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_ITEM_PRICE);
			itemPrice = inputData();
			try {
				if (InputValidation.validateItemPrice(itemPrice)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemPrice;
	}

	/**
	 * Gets the item quantity.
	 *
	 * @return the item quantity
	 */
	public static String getItemQuantity() {
		String itemQuantity = null;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_ITEM_QUANTITY);
			itemQuantity = inputData();
			try {
				if (InputValidation.validateItemQuantity(itemQuantity)) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemQuantity;
	}

	/**
	 * Gets the item type.
	 *
	 * @return the item type
	 */
	public static String getItemType() {
		String itemType = null;
		while (true) {
			System.out.print(ConsoleMessages.ENTER_ITEM_TYPE);
			itemType = inputData();
			try {
				if (InputValidation.validateItemType(itemType)) {
					switch (itemType) {
					case "1":
						itemType = DiscountConstants.GROCERY;
						break;
					case "2":
						itemType = DiscountConstants.NON_GROCERY;
						break;
					}
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemType;
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

	/**
	 * Gets the user option.
	 *
	 * @return the user option
	 */
	public static String getUserOption() {
		String option = GenericConstants.INITIALIZE_STRING;
		while (true) {
			System.out.println(ConsoleMessages.ASK_OTHER_ITEM);
			option = inputData();
			if (GenericConstants.YES_OPTION.equalsIgnoreCase(option)
					|| GenericConstants.NO_OPTION.equalsIgnoreCase(option)) {
				break;
			} else {
				System.out.println(ConsoleMessages.WRONG_OPTION);
			}
		}
		return option;
	}

	/**
	 * Gets the customer details.
	 *
	 * @return the customer details
	 */
	public static String getCustomerDetails() {
		String customerType = null;
		while (true) {
			System.out.print(ConsoleMessages.CUSTOMER_TYPE);
			customerType = inputData();
			try {
				if (InputValidation.validateCustomerType(customerType)) {
					switch (customerType) {
					case "1":
						customerType = DiscountConstants.AFFILIATE_STRATEGY;
						break;
					case "2":
						customerType = DiscountConstants.EMPLOYEE_STRATEGY;
						break;
					case "3":
						customerType = DiscountConstants.SUBSCRIBED_STRATEGY;
						break;
					default:
						customerType = DiscountConstants.GUEST_STRATEGY;
					}
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return customerType;
	}

}
