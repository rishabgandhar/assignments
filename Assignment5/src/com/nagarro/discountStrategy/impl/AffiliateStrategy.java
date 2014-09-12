package com.nagarro.discountStrategy.impl;

import java.util.List;

import com.nagarro.constants.DiscountConstants;
import com.nagarro.constants.GenericConstants;
import com.nagarro.discountStrategy.DiscountStrategy;
import com.nagarro.model.Item;
import com.nagarro.model.ItemType;
import com.nagarro.model.Order;

/**
 * The Class AffiliateStrategy.
 */
public class AffiliateStrategy implements DiscountStrategy {


	@Override
	public Double calculateBill(List<Order> orders) {
		Double payableValue = GenericConstants.INITIALIZE_VALUE;
		for (Order order : orders) {
			Double orderValue;
			Item item = order.getItem();
			if (item.getItemType().equals(ItemType.valueOf("GROCERY"))) {
				System.out.println("Grocery Item");
				orderValue = item.getItemPrice();
			} else {
				orderValue = item.getItemPrice()
						- (DiscountConstants.AFFILIATE_DISCOUNT_VALUE * item
								.getItemPrice());
			}
			payableValue += orderValue;
		}
		return payableValue;
	}

}
