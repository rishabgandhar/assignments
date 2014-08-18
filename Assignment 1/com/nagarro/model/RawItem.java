package com.nagarro.model;

import com.nagarro.constant.Constants;

/**
 * Item class when the type is raw
 * 
 * @author rishabgandhar
 *
 */
public class RawItem extends Item {

	@Override
	public double getCalculatedItemSalesTax() {
		double itemSalesTax = Constants.SALES_TAX * getItemPrice();
		return itemSalesTax;
	}

}
