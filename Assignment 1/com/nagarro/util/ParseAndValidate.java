package com.nagarro.util;

import com.nagarro.constant.Constants;
import com.nagarro.model.Item;
import com.nagarro.model.Order;

/**
 * This class parses the input, extracts the item data and then validates it
 * 
 * @author Rishab
 *
 */
public class ParseAndValidate {
	private static String itemName;
	private static double itemPrice;
	private static int itemQuantity;
	private static String itemType;
	private static int index;

	/**
	 * This method parses the input data and extract the item data from it
	 * 
	 * @param tokens
	 *
	 */
	public static void parse(String tokens[]) throws ItemExceptions {
		initialize();
		for (index = 0; index < tokens.length; index++) {
			if (index == 0) {
				if (isName(tokens))
					;
				else {
					itemName = Constants.INVALID_IDENTIFIER;
				}
			} else {
				if (isPrice(tokens))
					;
				else if (isType(tokens))
					;
				else if (isQuantity(tokens))
					;
				else {
					itemName = Constants.INVALID_IDENTIFIER;
				}
			}
		}

	}

	/**
	 * This method generates an order from the data parsed by the parser
	 * 
	 * @return Order
	 * @throws ItemExceptions
	 */
	public static Order getOrder() throws ItemExceptions {
		Item item = ItemFactory.getInstance(itemType);
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		Order order = new Order();
		order.setItem(item);
		order.setQuantity(itemQuantity);
		return order;
	}

	/**
	 * This method finds whether name token and its value is present in input
	 * string or not
	 * 
	 * @param tokens
	 * @return true if name found else false
	 */
	public static boolean isName(String[] tokens) {
		boolean found = false;
		if (!(tokens[index].equals(Constants.NAME_TOKEN))) {
			itemName = null;
		} else {
			found = true;
			index++;
			if (index >= tokens.length) {
				itemName = null;
			} else if (tokens[index].startsWith(Constants.KEY_DETERMINER)) {
				itemName = null;
			} else {
				itemName = Constants.INITIALIZE_STRING;
				while (index < tokens.length
						&& (!(tokens[index].startsWith("-")))) {
					itemName += tokens[index] + Constants.INPUT_SPLITTER;
					index++;
				}
				index--;
			}
		}
		return found;
	}

	/**
	 * This method finds whether price token and its value is present in input
	 * string or not
	 * 
	 * @param tokens
	 * @return true if price found else false
	 */
	public static boolean isPrice(String[] tokens) {
		boolean found = false;
		if (tokens[index].equals(Constants.PRICE_TOKEN)) {
			found = true;
			index++;
			if (index >= tokens.length) {
				itemPrice = 0;
			} else if (tokens[index].startsWith(Constants.KEY_DETERMINER)) {
				try {
					itemPrice = Double.parseDouble(tokens[index]);
				} catch (NumberFormatException exception) {
					index--;
					itemPrice = 0;
				}
			} else {
				try {
					itemPrice = Double.parseDouble(tokens[index]);
				} catch (NumberFormatException e) {
					itemPrice = 0;
				}
			}
		}
		return found;
	}

	/**
	 * This method finds whether type token and its value is present in input
	 * string or not
	 * 
	 * @param tokens
	 * @return true if type found else false
	 */
	public static boolean isType(String[] tokens) {
		boolean found = false;
		if (tokens[index].equals(Constants.TYPE_TOKEN)) {
			found = true;
			index++;
			if (index >= tokens.length) {
				itemType = null;
			} else if (tokens[index].startsWith(Constants.KEY_DETERMINER)) {
				index--;
				itemType = null;
			} else {
				itemType = tokens[index];
			}
		}
		return found;
	}

	/**
	 * This method finds whether quantity token and its value is present in
	 * input string or not
	 * 
	 * @param tokens
	 * @return true if quantity found else false
	 */
	public static boolean isQuantity(String[] tokens) {
		boolean found = false;
		if (tokens[index].equals(Constants.QUANTITY_TOKEN)) {
			found = true;
			index++;
			if (index >= tokens.length) {
				itemQuantity = 0;
			} else if (tokens[index].startsWith(Constants.KEY_DETERMINER)) {
				try {
					itemQuantity = Integer.parseInt(tokens[index]);
				} catch (NumberFormatException exception) {
					index--;
					itemQuantity = 0;
				}
			} else {
				try {
					itemQuantity = Integer.parseInt(tokens[index]);
				} catch (NumberFormatException e) {
					itemQuantity = 0;
				}
			}
		}
		return found;
	}

	/**
	 * This method validates the generated Order based on some business rules
	 * 
	 * @return true if order is valid else false
	 * @throws ItemExceptions
	 */
	public static boolean validate() throws ItemExceptions {
		String exception = Constants.INITIALIZE_STRING;
		if (itemName.equals(Constants.INVALID_IDENTIFIER)) {
			exception += Constants.NEW_LINE + Constants.INVALID_FORMAT;
		} else {
			if (itemName == null) {
				exception += Constants.NEW_LINE + Constants.NULL_NAME;
			}
			if (itemPrice == 0.0) {
				exception += Constants.NEW_LINE + Constants.NULL_PRICE;
			} else if (itemPrice < 0.0) {
				exception += Constants.NEW_LINE + Constants.NEGATIVE_PRICE;
			}
			if (itemType == null) {
				exception += Constants.NEW_LINE + Constants.NULL_TYPE;
			} else if (!((itemType.equalsIgnoreCase(Constants.RAW_TYPE))
					|| (itemType.equalsIgnoreCase(Constants.MANUFACTURED_TYPE)) || (itemType
						.equalsIgnoreCase(Constants.IMPORTED_TYPE)))) {
				exception += Constants.NEW_LINE + Constants.INVALID_TYPE;
			}
			if (itemQuantity < 0) {
				exception += Constants.NEW_LINE + Constants.NEGATIVE_QUANTITY;
			} else if (itemQuantity == Constants.NO_QUANTITY) {
				itemQuantity = Constants.DEFAULT_QUANTITY;
			}
		}
		if (!exception.equals("")) {
			throw new ItemExceptions(exception);
		}
		return true;
	}

	/**
	 * This method initialize the item data to some default values
	 */
	public static void initialize() {
		itemName = Constants.NULL;
		itemPrice = Constants.INITIALIZE_PRICE;
		itemQuantity = Constants.INITIALIZE_QUANTITY;
		itemType = Constants.NULL;
		index = Constants.INITIALIZE_INDEX;
	}
}