package com.nagarro.model;

/**
 * This class defines the design of an order with attributes as item and its
 * quantity
 * 
 * @author rishabgandhar
 *
 */
public class Order {
	private Item item;
	private int quantity;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
