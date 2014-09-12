package com.nagarro.util;

import com.nagarro.constants.GarmentConstants;

/**
 * The Class InputValidation.
 */
public class InputValidation {

	/**
	 * Validate garment name.
	 *
	 * @param garmentName
	 *            the garment name
	 * @return true, if successful
	 */
	public static boolean validateGarmentName(String garmentName) {
		boolean isValid = false;
		if (GarmentConstants.SHIRT.equalsIgnoreCase(garmentName)
				|| GarmentConstants.TROUSER.equalsIgnoreCase(garmentName)) {
			isValid = true;
		}
		return isValid;
	}

}
