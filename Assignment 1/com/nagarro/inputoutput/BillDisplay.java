package com.nagarro.inputoutput;

import java.util.List;

import com.nagarro.constant.Constants;
import com.nagarro.model.Order;

/**
 * This class displays all the orders of a user
 * 
 * @author rishabgandhar
 *
 */
public class BillDisplay {
	/**
	 * This method prints the details of all the orders placed by the user
	 * 
	 * @param bill
	 */
	public static void displayBill(List<Order> bill) {
		for (int i = 0; i < bill.size(); i++) {
			Order order = bill.get(i);
			System.out.println(Constants.BILL_DESIGN);
			System.out.println(Constants.ITEM_NAME
					+ order.getItem().getItemName());
			System.out.println(String.format(Constants.ITEM_PRICE, order
					.getItem().getItemPrice()));
			System.out.println(String.format(Constants.ITEM_SALES_TAX, order
					.getItem().getCalculatedItemSalesTax()));
			System.out.println(String.format(Constants.ITEM_FINAL_PRICE,
					order.getQuantity()
									* (order.getItem()
											.getCalculatedItemSalesTax() + order
											.getItem().getItemPrice())));
		}
		System.out.println(Constants.BILL_DESIGN);
	}
}
