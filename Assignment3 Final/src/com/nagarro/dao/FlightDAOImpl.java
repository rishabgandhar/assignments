package com.nagarro.dao;

import static com.nagarro.constants.CSVReaderConstants.DATE_FORMAT;
import static com.nagarro.constants.CSVReaderConstants.DELIMITER;
import static com.nagarro.constants.CSVReaderConstants.OPTION_A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.Flight;
import com.nagarro.util.HibernateUtility;

/**
 * The Class FlightDAOImpl.
 */
public class FlightDAOImpl implements FlightDAO {

	@Override
	public void setFlightDatabase(List<Flight> flights) {
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		try {
			for (Flight flight : flights) {
				Criteria criteria = session.createCriteria(Flight.class);
				Criterion flight_Number = Restrictions.eq("flightNumber",
						flight.getFlightNumber());
				Criterion flight_Time = Restrictions.eq("flightTime",
						flight.getFlightTime());
				LogicalExpression andExpression = Restrictions.and(
						flight_Number, flight_Time);
				criteria.add(andExpression);
				@SuppressWarnings("rawtypes")
				List presentFlights = criteria.list();
				if (presentFlights.isEmpty()) {
					session.save(flight);
				}
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@Override
	public List<Flight> getFlightList(String key, String userInput) {
		String keyData[] = key.split("_");
		String flightDep = keyData[0];
		String flightArr = keyData[1];
		String flightClass = keyData[2];
		int index = userInput.lastIndexOf(DELIMITER);
		int index2 = userInput.lastIndexOf(DELIMITER, index - 1);
		String inputDate = userInput.substring(index2 + 1, index);
		String option = userInput
				.substring(userInput.lastIndexOf(DELIMITER) + 1);
		if (option.equalsIgnoreCase(OPTION_A)) {
			option = "flightfare";
		} else {
			option = "flightduration,flightfare";
		}
		java.sql.Date sqlDate;
		try {
			Date date = new SimpleDateFormat(DATE_FORMAT).parse(inputDate);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			sqlDate = null;
		}
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		String hqlQuery = "from Flight as F where F.flightDeparture='"
				+ flightDep + "' and F.flightArrival='" + flightArr
				+ "' and F.flightClass like '%" + flightClass
				+ "%' and F.validTill>='" + sqlDate
				+ "' and F.flightAvailability=" + true + " order by " + option;
		@SuppressWarnings("unchecked")
		List<Flight> flights = (List<Flight>) (session.createQuery(hqlQuery)
				.list());
		flights.get(0).setAirlineName("Air India Data");
		session.getTransaction().commit();
		return flights;
	}
}
