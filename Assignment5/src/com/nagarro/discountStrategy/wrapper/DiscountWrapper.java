package com.nagarro.discountStrategy.wrapper;

import java.util.List;

import com.nagarro.constants.ConsoleMessages;
import com.nagarro.constants.DiscountConstants;
import com.nagarro.discountStrategy.DiscountStrategy;
import com.nagarro.model.Order;
import com.nagarro.util.LoggerUtility;

/**
 * The Class DiscountWrapper.
 */
public class DiscountWrapper implements DiscountStrategy {

	/** The strategy. */
	private DiscountStrategy strategy;

	/**
	 * Instantiates a new discount wrapper.
	 *
	 * @param strategy
	 *            the strategy
	 */
	public DiscountWrapper(DiscountStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public Double calculateBill(List<Order> orders) throws Exception {
		Double netPayableAmount = null;
		try {
			netPayableAmount = strategy.calculateBill(orders);
			if (netPayableAmount > DiscountConstants.FIXED_VALUE) {
				int multiplier = (int) (netPayableAmount % DiscountConstants.FIXED_VALUE);
				netPayableAmount -= multiplier
						* DiscountConstants.FIXED_DISCOUNT_MULTIPLIER;
			}
		} catch (Exception exception) {
			LoggerUtility.getLogger(DiscountStrategy.class.getName()).error(
					ConsoleMessages.ERROR_MESSAGE, exception);
			throw new Exception(ConsoleMessages.ERROR_MESSAGE);
		}
		return netPayableAmount;
	}
}
