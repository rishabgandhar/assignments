package com.nagarro.inputoutput;

import static com.nagarro.constants.StringConstants.FILE_PATH;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;

/**
 * The Class CSVReader.
 */
public class CSVReader {

	/**
	 * Read.
	 *
	 * @param flightService
	 *            the flight service
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void read(FlightService flightService) throws SQLException,
			FileNotFoundException, IOException, ParseException,
			ClassNotFoundException {
		List<Flight> flights = new ArrayList<>();
		File file = new File(FILE_PATH);
		File[] list = file.listFiles();
		for (File currentFile : list) {
			if (currentFile.getName().endsWith(".csv")) {
				String flightName = currentFile.getName().substring(0,
						currentFile.getName().indexOf("."));
				FileReader fr = new FileReader(currentFile);
				BufferedReader bufferedReader = new BufferedReader(fr);
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					if (line.startsWith("FLIGHT_NO")) {
						continue;
					}
					line += "|" + flightName;
					String airlineData[] = line.split("\\|");
					if (airlineData.length != 10) {
						continue;
					}
					Flight flight = Flight.getInstance(airlineData,
							"util");
					flights.add(flight);
				}
				bufferedReader.close();
			}
		}
		flightService.setFlightMap(flights);
	}
}
