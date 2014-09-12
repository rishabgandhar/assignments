package com.nagarro.dao;

import static com.nagarro.constants.CSVReaderConstants.DELIMITER;
import static com.nagarro.constants.CSVReaderConstants.OPTION_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nagarro.model.Flight;
import com.nagarro.util.DateParser;
import com.nagarro.util.JDBCUtility;

public class FlightDAOImplJDBC implements FlightDAO {

	@Override
	public void setFlightDatabase(List<Flight> flights) {
		Connection conn = JDBCUtility.getConnection();
		for (Flight flight : flights) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet resultSet = stmt
						.executeQuery("select * from flights where flightnumber='"
								+ flight.getFlightNumber()
								+ "' and flighttime='"
								+ flight.getFlightTime()
								+ "'");
				if (!resultSet.next()) {
					String sqlQuery = "INSERT INTO flights " + "VALUES ('"
							+ flight.getAirlineName() + "', '"
							+ flight.getFlightNumber() + "', '"
							+ flight.getFlightDeparture() + "', '"
							+ flight.getFlightArrival() + "', '"
							+ flight.getValidTill() + "', '"
							+ flight.getFlightTime() + "', "
							+ flight.getFlightDuration() + ", "
							+ flight.getFlightFare() + ", '"
							+ flight.getFlightClass() + "', "
							+ flight.getFlightAvailability() + ")";
					stmt.executeUpdate(sqlQuery);
				}
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			Date date = DateParser.parseDate(inputDate);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			sqlDate = null;
		}
		Connection conn = JDBCUtility.getConnection();
		List<Flight> flights = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("select * from flights where flightdeparture='"
							+ flightDep
							+ "' and flightarrival='"
							+ flightArr
							+ "' and flightclass like '%"
							+ flightClass
							+ "%' and validtill>='"
							+ sqlDate
							+ "' and flightavailability="
							+ true
							+ " order by "
							+ option);
			flights = getFlightList(resultSet);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}

	private List<Flight> getFlightList(ResultSet resultSet) throws SQLException {
		List<Flight> flights = new ArrayList<>();
		String flightData[] = new String[10];
		while (resultSet.next()) {
			flightData[9] = resultSet.getString("airlinename");
			flightData[0] = resultSet.getString("flightnumber");
			flightData[1] = resultSet.getString("flightdeparture");
			flightData[2] = resultSet.getString("flightarrival");
			flightData[3] = resultSet.getString("validtill");
			flightData[4] = resultSet.getString("flighttime");
			flightData[5] = resultSet.getString("flightduration");
			flightData[6] = resultSet.getString("flightfare");
			flightData[7] = resultSet.getString("flightclass");
			flightData[8] = resultSet.getString("flightavailability");
			Flight flight = Flight.getInstance(flightData, "sql");
			flights.add(flight);
		}
		return flights;
	}

}
