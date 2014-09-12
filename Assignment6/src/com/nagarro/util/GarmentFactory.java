package com.nagarro.util;

import com.nagarro.constants.GarmentConstants;
import com.nagarro.model.Garment;
import com.nagarro.model.Shirt;
import com.nagarro.model.Trouser;

/**
 * A factory for creating Garment objects.
 */
public class GarmentFactory {

	/**
	 * Gets the single instance of Garment.
	 *
	 * @param typeOfChoice
	 *            the type of choice
	 * @return single instance of Garment
	 */
	public static Garment getInstance(String typeOfChoice) {
		Garment garment = null;
		if (GarmentConstants.SHIRT.equalsIgnoreCase(typeOfChoice)) {
			garment = new Shirt();
		} else if (GarmentConstants.TROUSER.equalsIgnoreCase(typeOfChoice)) {
			garment = new Trouser();
		}
		return garment;
	}

}
