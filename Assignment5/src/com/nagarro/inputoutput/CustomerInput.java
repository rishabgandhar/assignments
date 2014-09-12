package com.nagarro.inputoutput;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.constants.GenericConstants;
import com.nagarro.model.Order;
import com.nagarro.util.ConsoleInput;
import com.nagarro.util.ParseDetails;

/**
 * The Class CustomerInput.
 */
public class CustomerInput {

	/**
	 * Input item details.
	 *
	 * @return the string
	 */
	public static String inputItemDetails() {
		String itemName = ConsoleInput.getItemName();
		String itemPrice = ConsoleInput.getItemPrice();
		String itemQuantity = ConsoleInput.getItemQuantity();
		String itemType = ConsoleInput.getItemType();
		String finalInput = itemName + GenericConstants.DELIMITER + itemPrice
				+ GenericConstants.DELIMITER + itemQuantity
				+ GenericConstants.DELIMITER + itemType;
		return finalInput;
	}

	/**
	 * Input customer details.
	 *
	 * @return the string
	 */
	public static String inputCustomerDetails() {
		String customerDetails = ConsoleInput.getCustomerDetails();
		return customerDetails;
	}

	/**
	 * Checks for more items.
	 *
	 * @return the boolean
	 */
	public static Boolean hasMoreItems() {
		boolean status;
		String option = ConsoleInput.getUserOption();
		if (GenericConstants.YES_OPTION.equalsIgnoreCase(option)) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	/**
	 * Gets the list of items.
	 *
	 * @return the list of items
	 */
	public static List<Order> getListofItems() {
		List<Order> orders = new ArrayList<>();
		do {
			String itemDetails = inputItemDetails();
			Order order = ParseDetails.parseOrderDetails(itemDetails);
			orders.add(order);
		} while (CustomerInput.hasMoreItems());
		return orders;
	}
}
