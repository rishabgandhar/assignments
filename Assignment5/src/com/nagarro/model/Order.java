package com.nagarro.model;

/**
 * The Class Order.
 */
public class Order {

	/** The item. */
	private Item item;
	
	/** The item quantity. */
	private Integer itemQuantity;

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param item
	 *            the new item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Gets the item quantity.
	 *
	 * @return the item quantity
	 */
	public Integer getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * Sets the item quantity.
	 *
	 * @param itemQuantity
	 *            the new item quantity
	 */
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
}
