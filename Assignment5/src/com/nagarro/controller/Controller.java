package com.nagarro.controller;

import java.util.List;

import com.nagarro.discountStrategy.DiscountStrategy;
import com.nagarro.discountStrategy.wrapper.DiscountWrapper;
import com.nagarro.inputoutput.CustomerInput;
import com.nagarro.inputoutput.CustomerOutput;
import com.nagarro.model.Order;
import com.nagarro.util.ConsoleOutput;
import com.nagarro.util.DiscountStrategyFactory;
import com.nagarro.util.ParseDetails;

/**
 * The Class Controller.
 */
public class Controller {

	/**
	 * Start.
	 */
	public void start() {
		try {
			List<Order> orders = CustomerInput.getListofItems();
			String customerDetails = CustomerInput.inputCustomerDetails();
			String typeOfStrategy = ParseDetails
					.parseCustomerType(customerDetails);
			DiscountStrategy strategy = DiscountStrategyFactory
					.getInstance(typeOfStrategy);
			DiscountStrategy discountWrapper = new DiscountWrapper(strategy);
			Double netPayableAmount = discountWrapper.calculateBill(orders);
			CustomerOutput.displayBill(netPayableAmount);
		} catch (Exception exception) {
			ConsoleOutput.display(exception.getMessage());
		}
	}
}
