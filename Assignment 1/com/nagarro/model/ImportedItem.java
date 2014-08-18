package com.nagarro.model;

import com.nagarro.constant.Constants;

/**
 * Item class when the type is imported
 * 
 * @author rishabgandhar
 *
 */
public class ImportedItem extends Item {

	@Override
	public double getCalculatedItemSalesTax() {
		double itemSalesTax = Constants.SALES_TAX * getItemPrice();
		double itemImportDuty = Constants.IMPORT_DUTY * getItemPrice();
		double itemTotalTax = itemSalesTax + itemImportDuty + getItemPrice();
		if (itemTotalTax <= Constants.LOWER_TAX_LIMIT) {
			itemTotalTax += Constants.SURCGARGE_1;
		} else if (itemTotalTax > Constants.LOWER_TAX_LIMIT
				&& itemTotalTax <= Constants.UPPER_TAX_LIMIT) {
			itemTotalTax += Constants.SURCGARGE_2;
		} else {
			itemTotalTax += (Constants.SURCGARGE_3 * itemTotalTax);
		}
		itemTotalTax -= getItemPrice();
		return itemTotalTax;
	}

}
