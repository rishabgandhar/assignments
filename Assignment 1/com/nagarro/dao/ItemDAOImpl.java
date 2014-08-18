package com.nagarro.dao;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.constant.Constants;
import com.nagarro.model.Order;

/**
 * This class is an implementation of ItemDAO and acts as a Data Access Object
 * class
 * 
 * @author rishabgandhar
 *
 */
public class ItemDAOImpl implements ItemDAO {

	/**
	 * This List contains all the orders of the user
	 */
	public static List<Order> orderList = new ArrayList<>();

	@Override
	public void addOrder(Order order) {
		orderList.add(order);
		System.out.println(Constants.ITEM_ADDED);
	}

	@Override
	public List<Order> getOrderList() {
		return orderList;
	}
	
}
