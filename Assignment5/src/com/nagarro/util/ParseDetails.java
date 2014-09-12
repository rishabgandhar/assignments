package com.nagarro.util;

import com.nagarro.constants.GenericConstants;
import com.nagarro.model.Item;
import com.nagarro.model.ItemType;
import com.nagarro.model.Order;

/**
 * The Class ParseDetails.
 */
public class ParseDetails {

	/**
	 * Parses the customer type.
	 *
	 * @param customerDetails
	 *            the customer details
	 * @return the string
	 */
	public static String parseCustomerType(String customerDetails) {
		return customerDetails;
	}

	/**
	 * Parses the order details.
	 *
	 * @param itemDetails
	 *            the item details
	 * @return the order
	 */
	public static Order parseOrderDetails(String itemDetails) {
		String itemDetailTokens[] = itemDetails
				.split(GenericConstants.DELIMITER);
		String itemName = itemDetailTokens[GenericConstants.NAME_INDEX];
		Double itemPrice = Double
				.parseDouble(itemDetailTokens[GenericConstants.PRICE_INDEX]);
		Integer itemQuantity = Integer
				.parseInt(itemDetailTokens[GenericConstants.QUANTITY_INDEX]);
		ItemType itemType = ItemType
				.valueOf(itemDetailTokens[GenericConstants.TYPE_INDEX]);
		Item item = getItemInstance(itemName, itemPrice, itemType);
		Order order = getOrderInstance(itemQuantity, item);
		return order;
	}

	/**
	 * Gets the order instance.
	 *
	 * @param itemQuantity
	 *            the item quantity
	 * @param item
	 *            the item
	 * @return the order instance
	 */
	private static Order getOrderInstance(Integer itemQuantity, Item item) {
		Order order = new Order();
		order.setItem(item);
		order.setItemQuantity(itemQuantity);
		return order;
	}

	/**
	 * Gets the item instance.
	 *
	 * @param itemName
	 *            the item name
	 * @param itemPrice
	 *            the item price
	 * @param itemType
	 *            the item type
	 * @return the item instance
	 */
	private static Item getItemInstance(String itemName, Double itemPrice,
			ItemType itemType) {
		Item item = new Item();
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		item.setItemType(itemType);
		return item;
	}
}
