package com.nagarro.inputoutput;

import static com.nagarro.constants.CSVReaderConstants.FILE_EXTENSION;
import static com.nagarro.constants.CSVReaderConstants.FILE_PATH;
import static com.nagarro.constants.CSVReaderConstants.FIRST_LINE;
import static com.nagarro.constants.CSVReaderConstants.SPLITTER;
import static com.nagarro.constants.CharConstants.BUSINESS;
import static com.nagarro.constants.NumericConstants.BUSINESS_FARE_INCREMENT;
import static com.nagarro.constants.NumericConstants.CLASS_INDEX;
import static com.nagarro.constants.NumericConstants.TOTAL_TOKENS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.constants.CSVReaderConstants;
import com.nagarro.constants.GenericConstants;
import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;
import com.nagarro.service.FlightServiceImpl;
import com.nagarro.util.DateParser;

/**
 * The Class CSVReader.
 */
public class CSVReader {

	/** The files. */

	/** The files. */
	private Map<File, Date> fileMap = new HashMap<>();

	/**
	 * Gets the single instance of FlightFactory.
	 *
	 * @param data
	 *            the data
	 * @return single instance of FlightFactory
	 */
	public static Flight getInstance(String data[]) {
		Flight flight = new Flight();
		flight.setFlightNumber(data[0]);
		flight.setFlightDeparture(data[1]);
		flight.setFlightArrival(data[2]);
		try {
			flight.setValidTill(DateParser.parseDate(data[3]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		flight.setFlightTime(data[4]);
		flight.setFlightDuration(Double.parseDouble(data[5]));
		flight.setFlightFare(Double.parseDouble(data[6]));
		flight.setFlightClass(data[8]);
		if (GenericConstants.YES_OPTION.equalsIgnoreCase(data[7])) {
			flight.setFlightAvailability(true);
		} else {
			flight.setFlightAvailability(false);
		}
		flight.setAirlineName(data[9]);
		return flight;
	}

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
	public void read() throws FileNotFoundException, IOException {
		List<Flight> flights = new ArrayList<>();
		File file = new File(FILE_PATH);
		if (file.exists() && file.isDirectory()) {
			File[] list = file.listFiles();
			for (File currentFile : list) {
				if (currentFile.getName().endsWith(FILE_EXTENSION)) {
					if (!fileMap.containsKey(currentFile)
							|| fileMap.get(currentFile).before(
									new Date(currentFile.lastModified()))) {
						String flightName = currentFile.getName().substring(0,
								currentFile.getName().indexOf("."));
						FileReader fr = new FileReader(currentFile);
						BufferedReader bufferedReader = new BufferedReader(fr);
						String line = GenericConstants.INITIALIZE_STRING;
						while ((line = bufferedReader.readLine()) != null) {
							if (line.startsWith(FIRST_LINE)) {
								continue;
							}
							line += "|" + flightName;
							String airlineData[] = line.split(SPLITTER);
							if (airlineData.length != TOTAL_TOKENS) {
								continue;
							}
							for (int index = 0; index < airlineData[CLASS_INDEX]
									.length(); index++) {
								Flight flight = getInstance(airlineData);
								if (airlineData[CLASS_INDEX].charAt(index) == BUSINESS) {
									flight.setFlightClass(CSVReaderConstants.BUSINESS);
									flight.setFlightFare(flight.getFlightFare()
											+ flight.getFlightFare()
											* BUSINESS_FARE_INCREMENT);
								} else {
									flight.setFlightClass(CSVReaderConstants.ECONOMIC);
								}
								flights.add(flight);
							}
						}
						fileMap.put(currentFile,
								new Date(currentFile.lastModified()));
						bufferedReader.close();
					}
				}
			}
			FlightService flightService = FlightServiceImpl.getInstance();
			flightService.setList(flights);
		}
	}
}
