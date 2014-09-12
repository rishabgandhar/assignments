package com.nagarro.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nagarro.constants.GenericConstants;

/**
 * The Class LoggerUtility.
 */
public class LoggerUtility {

	/** The logger. */
	private static Logger logger;

	static {
		PropertyConfigurator.configure(GenericConstants.LOG4J_PROPERTIES);
	}

	/**
	 * Gets the logger.
	 *
	 * @param className
	 *            the class name
	 * @return the logger
	 */
	public static Logger getLogger(String className) {
		logger = Logger.getLogger(className);
		return logger;
	}
}
