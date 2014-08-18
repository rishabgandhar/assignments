package com.nagarro.service;

import java.util.List;

import com.nagarro.dao.ItemDAO;
import com.nagarro.dao.ItemDAOImpl;
import com.nagarro.model.Order;

/**
 * This class is an implementation of ItemSerice and acts as a Item Service
 * class
 * 
 * @author rishabgandhar
 *
 */
public class ItemServiceImpl implements ItemService {

	public ItemDAO itemdao = new ItemDAOImpl();
	@Override
	public void addOrder(Order order) {
		itemdao.addOrder(order);
	}

	@Override
	public List<Order> getOrderList() {
		return itemdao.getOrderList();
	}

}
