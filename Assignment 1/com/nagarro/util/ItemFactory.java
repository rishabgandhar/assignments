package com.nagarro.util;

import com.nagarro.constant.Constants;
import com.nagarro.model.ImportedItem;
import com.nagarro.model.Item;
import com.nagarro.model.ManufacturedItem;
import com.nagarro.model.RawItem;
/**
 * This class provides the instance of an item and acts as an item factory
 * @author Rishab
 *
 */
public class ItemFactory {
/**
 * This method creates an item of given parameter as its type
 * @param type of the item
 * @return item
 * @throws ItemExceptions
 */
	public static Item getInstance(String type) throws ItemExceptions {
		Item item;
		if (type.equals(Constants.RAW_TYPE)) {
			item = new RawItem();
		} else if (type.equals(Constants.MANUFACTURED_TYPE)) {
			item = new ManufacturedItem();
		} else if (type.equals(Constants.IMPORTED_TYPE)) {
			item = new ImportedItem();
		} else {
			throw new ItemExceptions(Constants.INVALID_TYPE);
		}
		return item;
	}
}
