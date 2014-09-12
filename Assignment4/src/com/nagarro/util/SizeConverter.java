package com.nagarro.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SizeConverter {
	public static String convertSize(long size) {
		String finalValue;
		Double value;
		double tempSize = size;
		NumberFormat formatter = new DecimalFormat("#0.00");
		if (size < 1024 * 1024) {
			value = (double) (tempSize / 1024);
			finalValue = formatter.format(value);
			finalValue += " KB";
		} else {
			value = (double) (tempSize / (1024 * 1024));
			finalValue = formatter.format(value);
			finalValue += " MB";
		}
		return finalValue;
	}

}
