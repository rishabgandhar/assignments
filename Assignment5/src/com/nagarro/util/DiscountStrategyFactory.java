package com.nagarro.util;

import com.nagarro.constants.DiscountConstants;
import com.nagarro.discountStrategy.DiscountStrategy;
import com.nagarro.discountStrategy.impl.AffiliateStrategy;
import com.nagarro.discountStrategy.impl.EmployeeStrategy;
import com.nagarro.discountStrategy.impl.GuestStrategy;
import com.nagarro.discountStrategy.impl.SubscricptionStrategy;

/**
 * A factory for creating DiscountStrategy objects.
 */
public class DiscountStrategyFactory {

	/**
	 * Gets the single instance of DiscountStrategy.
	 *
	 * @param typeOfCustomer
	 *            the type of customer
	 * @return single instance of DiscountStrategy
	 */
	public static DiscountStrategy getInstance(String typeOfCustomer) {
		DiscountStrategy strategy = null;
		if (DiscountConstants.EMPLOYEE_STRATEGY
				.equalsIgnoreCase(typeOfCustomer)) {
			strategy = new EmployeeStrategy();
		} else if (DiscountConstants.AFFILIATE_STRATEGY
				.equalsIgnoreCase(typeOfCustomer)) {
			strategy = new AffiliateStrategy();
		} else if (DiscountConstants.SUBSCRIBED_STRATEGY
				.equalsIgnoreCase(typeOfCustomer)) {
			strategy = new SubscricptionStrategy();
		} else if (DiscountConstants.GUEST_STRATEGY
				.equalsIgnoreCase(typeOfCustomer)) {
			strategy = new GuestStrategy();
		}
		return strategy;
	}

}
