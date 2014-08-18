package com.nagarro.controller;

import java.util.List;

import com.nagarro.constant.Constants;
import com.nagarro.inputoutput.AddMoreItems;
import com.nagarro.inputoutput.BillDisplay;
import com.nagarro.inputoutput.DisplayError;
import com.nagarro.inputoutput.UserInput;
import com.nagarro.model.Order;
import com.nagarro.service.ItemService;
import com.nagarro.service.ItemServiceImpl;
import com.nagarro.util.InputTokenizer;
import com.nagarro.util.ItemExceptions;
import com.nagarro.util.ParseAndValidate;

/**
 * This class is the driver class and controls the flow of the program
 * 
 * @author rishabgandhar
 *
 */
public class Controller {
	ItemService itemService = new ItemServiceImpl();
	/**
	 * Method acts as a dispatcher and calls all the other functions in the
	 * program
	 */
	public void start() {
		System.out.println(Constants.WELCOME_USER);
		System.out.println(Constants.FORMAT);
		do {
			String userInput = UserInput.input();
			try {
				String tokens[] = InputTokenizer.tokenizeInput(userInput);
				ParseAndValidate.parse(tokens);
				boolean isValidate = ParseAndValidate.validate();
				if (isValidate) {
					Order order = ParseAndValidate.getOrder();
					itemService.addOrder(order);
				}
			} catch (ItemExceptions exception) {
				DisplayError.display(exception.getMessage());
			}
		} while (AddMoreItems.addOtherItem());

		List<Order> orderList = itemService.getOrderList();
		BillDisplay.displayBill(orderList);

	}
}
