package com.nagarro.discountStrategy;

import java.util.List;

import com.nagarro.model.Order;

/**
 * The Interface DiscountStrategy.
 */
public interface DiscountStrategy {

	/**
	 * Calculate bill.
	 *
	 * @param orders
	 *            the orders
	 * @return the double Bill Value
	 * @throws Exception
	 *             the exception
	 */
	public Double calculateBill(List<Order> orders) throws Exception;
}
