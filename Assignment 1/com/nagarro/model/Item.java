package com.nagarro.model;

/**
 * This class defines an abstract design of an item with attributes item name
 * and item price
 * 
 * @author rishabgandhar
 *
 */
public abstract class Item {
	private String itemName;
	private double itemPrice;

	/**
	 * This method calculates the sales tax of an item depending on its type and
	 * returns it
	 * 
	 * @return Sales Tax of the item
	 */
	public abstract double getCalculatedItemSalesTax();

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
