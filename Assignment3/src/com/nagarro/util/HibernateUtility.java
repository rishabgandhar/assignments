package com.nagarro.util;

import java.util.logging.Level;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * The Class HibernateUtilities.
 * 
 * @author rishabgandhar
 */
@SuppressWarnings("deprecation")
public class HibernateUtility {

	/** The sessionfactory. */
	private static SessionFactory sessionfactory;

	static {
		try {
			java.util.logging.Logger.getLogger("org.hibernate").setLevel(
					Level.OFF);
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionfactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the sessionfactory.
	 *
	 * @return the sessionfactory
	 */
	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
}
