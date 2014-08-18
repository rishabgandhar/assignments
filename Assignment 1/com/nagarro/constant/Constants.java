package com.nagarro.constant;

/**
 * This class contains all the constant values which are used in different
 * classes.
 * 
 * @author rishabgandhar
 *
 */
public class Constants {

	private Constants() {
	}

	public static final String NULL = null;
	public static final String NULL_INPUT = "No User Input is Provided";
	public static final String WELCOME_USER = "Welcome to Online Billing System";
	public static final String ASK_USER = "Do you want to enter details of any other item (y/n):";
	public static final String ENTER_DETAILS = "Enter the details of item: ";
	public static final String NULL_NAME = "Name of the Item is not present";
	public static final String NULL_PRICE = "Price of the Item is not present";
	public static final String NULL_TYPE = "Type of the Item is not present";
	public static final String INVALID_NAME = "Name of the Item is not valid";
	public static final String INVALID_PRICE = "Price of the Item is not valid";
	public static final String NEGATIVE_PRICE = "Price of the Item can not be negative";
	public static final String NEGATIVE_QUANTITY = "Quantity of the Item can not be negative";
	public static final String INVALID_TYPE = "Type of the Item is not valid";
	public static final String INVALID_QUANTITY = "Quantity of the Item is not valid";
	public static final String INVALID_FORMAT = "Format of the Item is not valid";
	public static final String BILL_DESIGN = "-------------------------------------------------------------------------------";
	public static final String ITEM_NAME = "Item Name       : ";
	public static final String ITEM_PRICE = "Item Price      : %.2f";
	public static final String ITEM_SALES_TAX = "Item Sales Tax  : %.2f";
	public static final String ITEM_FINAL_PRICE = "Final Price     : %.2f";
	public static final double SALES_TAX = 0.125;
	public static final double IMPORT_DUTY = 0.1;
	public static final double MANUFACTURING_DUTY = 0.02;
	public static final int NO_QUANTITY = 0;
	public static final int DEFAULT_QUANTITY = 1;
	public static final int SURCGARGE_1 = 5;
	public static final int SURCGARGE_2 = 10;
	public static final double SURCGARGE_3 = 0.05;
	public static final int LOWER_TAX_LIMIT = 100;
	public static final int UPPER_TAX_LIMIT = 200;
	public static final String INITIALIZE_STRING = "";
	public static final String INITIALIZE_NAME = "";
	public static final double INITIALIZE_PRICE = 0;
	public static final String INITIALIZE_TYPE = "";
	public static final int INITIALIZE_QUANTITY = 0;
	public static final int TOTAL_KEYS = 4;
	public static final String INPUT_SPLITTER = " ";
	public static final String NAME_TOKEN = "-name";
	public static final String PRICE_TOKEN = "-price";
	public static final String TYPE_TOKEN = "-type";
	public static final String QUANTITY_TOKEN = "-quantity";
	public static final String KEY_DETERMINER = "-";
	public static final String INVALID_IDENTIFIER = "INVALID_ENTRY";
	public static final String RAW_TYPE = "raw";
	public static final String MANUFACTURED_TYPE = "manufactured";
	public static final String IMPORTED_TYPE = "imported";
	public static final String ITEM_ADDED = "Item Added to the Bill";
	public static final String VALID_OPTION = "Please Enter a valid option";
	public static final String NEW_LINE = "\n";
	public static final String FORMAT = "The input should be in a format\n-name <ItemName> -price <ItemPrice> -type<ItemType> -quantity<ItemQuantity>";
	public static final char YES_1 = 'y';
	public static final char YES_2 = 'Y';
	public static final char NO_1 = 'N';
	public static final char NO_2 = 'n';
	public static final int INITIALIZE_INDEX = 0;
}
