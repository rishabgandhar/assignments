package com.nagarro.util;

import com.nagarro.constants.GenericConstants;

/**
 * The Class InputValidation.
 */
public class InputValidation {

	/**
	 * Validate item name.
	 *
	 * @param itemName
	 *            the item name
	 * @return true, if successful
	 */
	public static boolean validateItemName(String itemName) {
		boolean isValid = true;
		if(itemName.trim().isEmpty()) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Validate item price.
	 *
	 * @param itemPrice
	 *            the item price
	 * @return true, if successful
	 */
	public static boolean validateItemPrice(String itemPrice) {
		boolean isValid = false;
		try {
			if (Double.parseDouble(itemPrice) > GenericConstants.INITIALIZE_VALUE) {
				isValid = true;
			}
		} catch (NumberFormatException exception) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Validate item quantity.
	 *
	 * @param itemQuantity
	 *            the item quantity
	 * @return true, if successful
	 */
	public static boolean validateItemQuantity(String itemQuantity) {
		boolean isValid = false;
		try {
			if (Integer.parseInt(itemQuantity) > GenericConstants.INITIALIZE_VALUE) {
				isValid = true;
			}
		} catch (NumberFormatException exception) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Validate item type.
	 *
	 * @param itemType
	 *            the item type
	 * @return true, if successful
	 */
	public static boolean validateItemType(String itemType) {
		boolean isValid = false;
		try {
			if (Integer.parseInt(itemType) == GenericConstants.OPTION_1
					|| Integer.parseInt(itemType) == GenericConstants.OPTION_2) {
				isValid = true;
			}
		} catch (NumberFormatException exception) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Validate customer type.
	 *
	 * @param customerType
	 *            the customer type
	 * @return true, if successful
	 */
	public static boolean validateCustomerType(String customerType) {
		boolean isValid = false;
		try {
			if (Integer.parseInt(customerType) <= GenericConstants.MIN_TYPE_VALUE
					&& Integer.parseInt(customerType) <= GenericConstants.MAX_TYPE_VALUE) {
				isValid = true;
			}
		} catch (NumberFormatException exception) {
			isValid = false;
		}
		return isValid;
	}

}
