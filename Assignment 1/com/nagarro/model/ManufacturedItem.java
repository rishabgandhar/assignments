package com.nagarro.model;

import com.nagarro.constant.Constants;

/**
 * Item class when the type is manufactured
 * 
 * @author rishabgandhar
 *
 */
public class ManufacturedItem extends Item {

	@Override
	public double getCalculatedItemSalesTax() {
		double itemSalesTax = Constants.SALES_TAX * getItemPrice();
		itemSalesTax = itemSalesTax
				+ (Constants.MANUFACTURING_DUTY * (getItemPrice() + itemSalesTax));
		return itemSalesTax;
	}

}
