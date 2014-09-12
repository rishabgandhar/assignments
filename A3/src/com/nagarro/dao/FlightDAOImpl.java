package com.nagarro.dao;

import static com.nagarro.constants.DatabaseConstants.DB_URL;
import static com.nagarro.constants.DatabaseConstants.PASS;
import static com.nagarro.constants.DatabaseConstants.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.constants.StringConstants;
import com.nagarro.model.Flight;

/**
 * The Class FlightDAOImpl.
 */
public class FlightDAOImpl implements FlightDAO {

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see com.nagarro.dao.FlightDAO#setFlightMap(java.util.Map)
	 */
	@Override
	public void setFlightMap(List<Flight> flights)
			throws ClassNotFoundException, SQLException {
		Connection conn = connectDatabase();
		for (Flight flight : flights) {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("select * from flights where flightnumber='"
							+ flight.getFlightNumber() + "' and flighttime='"
							+ flight.getFlightTime() + "'");
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
		}
		conn.close();
	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see com.nagarro.dao.FlightDAO#getList(java.lang.String)
	 */
	@Override
	public List<Flight> getList(String key) throws ClassNotFoundException,
			SQLException {
		int index = key.indexOf(StringConstants.DELIMITER);
		int index2 = key.indexOf(StringConstants.DELIMITER, index + 1);
		String flightDep = key.substring(0, index);
		String flightArr = key.substring(index + 1, index2);
		String flightClass = key.substring(index2 + 1);
		Connection conn = connectDatabase();
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt
				.executeQuery("select * from flights where flightdeparture='"
						+ flightDep + "' and flightarrival='" + flightArr
						+ "' and flightclass like '%" + flightClass
						+ "%' and flightavailability=" + true);
		stmt.close();
		conn.close();
		return getFlightList(resultSet);
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

	public static Connection connectDatabase() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}

}
