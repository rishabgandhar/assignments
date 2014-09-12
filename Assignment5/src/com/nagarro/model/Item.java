package com.nagarro.model;

/**
 * The Class Item.
 */
public class Item {

	/** The item name. */
	private String itemName;
	
	/** The item price. */
	private Double itemPrice;
	
	/** The item type. */
	private ItemType itemType;

	/**
	 * Gets the item type.
	 *
	 * @return the item type
	 */
	public ItemType getItemType() {
		return itemType;
	}

	/**
	 * Sets the item type.
	 *
	 * @param itemType
	 *            the new item type
	 */
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName
	 *            the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the item price.
	 *
	 * @return the item price
	 */
	public Double getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice
	 *            the new item price
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	};
}
