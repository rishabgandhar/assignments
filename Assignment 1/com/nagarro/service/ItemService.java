package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Order;

/**
 * This interface defines the standards for a class to implement itself as an
 * Item Service implementing business logic
 * 
 * @author rishabgandhar
 *
 */
public interface ItemService {

	/**
	 * This method adds an order to the list of all orders
	 * 
	 * @param order
	 */
	public void addOrder(Order order);

	/**
	 * This method returns the list of all orders
	 * 
	 * @return List of all Orders
	 */
	public List<Order> getOrderList();
}
