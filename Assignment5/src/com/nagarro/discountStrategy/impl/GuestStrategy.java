package com.nagarro.discountStrategy.impl;

import java.util.List;

import com.nagarro.constants.DiscountConstants;
import com.nagarro.constants.GenericConstants;
import com.nagarro.discountStrategy.DiscountStrategy;
import com.nagarro.model.Item;
import com.nagarro.model.Order;

/**
 * The Class GuestStrategy.
 */
public class GuestStrategy implements DiscountStrategy {

	@Override
	public Double calculateBill(List<Order> orders) {
		Double payableValue = GenericConstants.INITIALIZE_VALUE;
		for (Order order : orders) {
			Double orderValue;
			Item item = order.getItem();
			orderValue = item.getItemPrice()
					- (DiscountConstants.GUEST_DISCOUNT_VALUE * item
							.getItemPrice());
			payableValue += orderValue;
		}
		return payableValue;
	}
}
