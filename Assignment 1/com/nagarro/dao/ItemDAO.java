package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Order;

/**
 * This interface defines the standards for a class to implement itself as a
 * Data Access Object
 * 
 * @author rishabgandhar
 *
 */
public interface ItemDAO {

	/**
	 * This method adds an order to the list of all orders
	 * 
	 * @param order to be added
	 */
	public void addOrder(Order order);

	/**
	 * This method returns the list of all orders
	 * 
	 * @return List of all Orders
	 */
	public List<Order> getOrderList();
}
