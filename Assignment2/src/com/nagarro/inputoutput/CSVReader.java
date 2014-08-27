package com.nagarro.inputoutput;

import static com.nagarro.constants.CSVReaderConstants.DELIMITER;
import static com.nagarro.constants.CSVReaderConstants.FILE_EXTENSION;
import static com.nagarro.constants.CSVReaderConstants.FILE_PATH;
import static com.nagarro.constants.CSVReaderConstants.FIRST_LINE;
import static com.nagarro.constants.CSVReaderConstants.SPLITTER;
import static com.nagarro.constants.CharConstants.BUSINESS;
import static com.nagarro.constants.NumericConstants.ARR_INDEX;
import static com.nagarro.constants.NumericConstants.BUSINESS_FARE_INCREMENT;
import static com.nagarro.constants.NumericConstants.CLASS_INDEX;
import static com.nagarro.constants.NumericConstants.DEP_INDEX;
import static com.nagarro.constants.NumericConstants.TOTAL_TOKENS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nagarro.constants.CSVReaderConstants;
import com.nagarro.constants.GenericConstants;
import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;

/**
 * The Class CSVReader.
 */
public class CSVReader {

	/** The files. */

	/** The files. */
	private Set<File> files = new HashSet<>();

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
			String dateStr = data[3];
			DateFormat formatter;
			formatter = new SimpleDateFormat(CSVReaderConstants.DATE_FORMAT);
			flight.setValidTill((Date) formatter.parse(dateStr));
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
	public void read(FlightService flightService) throws FileNotFoundException,
			IOException {
		Map<String, List<Flight>> flightMap = flightService.getMap();
		if (flightMap == null) {
			flightMap = new HashMap<>();
		}
		File file = new File(FILE_PATH);
		File[] list = file.listFiles();
		if (files.size() < list.length) {
			for (File currentFile : list) {
				if (files.add(currentFile)
						&& currentFile.getName().endsWith(FILE_EXTENSION)) {
					String flightName = currentFile.getName().substring(0,
							currentFile.getName().indexOf("."));
					FileReader fr = new FileReader(currentFile);
					BufferedReader bufferedReader = new BufferedReader(fr);
					String key;
					String line = GenericConstants.INITIALIZE_STRING;
					while ((line = bufferedReader.readLine()) != null) {
						if (line.startsWith(FIRST_LINE)) {
							continue;
						}
						line += SPLITTER + flightName;
						String airlineData[] = line.split(SPLITTER);
						if (airlineData.length != TOTAL_TOKENS) {
							continue;
						}
						for (int index = 0; index < airlineData[CLASS_INDEX]
								.length(); index++) {
							Flight flight = getInstance(airlineData);
							if (airlineData[CLASS_INDEX].charAt(index) == BUSINESS) {
								flight.setFlightFare(flight.getFlightFare()
										+ flight.getFlightFare()
										* BUSINESS_FARE_INCREMENT);
							}
							key = airlineData[DEP_INDEX] + DELIMITER
									+ airlineData[ARR_INDEX] + DELIMITER
									+ airlineData[CLASS_INDEX].charAt(index);
							List<Flight> flights = flightMap.get(key);
							if (flights == null) {
								flights = new ArrayList<>();
								flightMap.put(key, flights);
							}
							flights.add(flight);
						}
					}
					bufferedReader.close();
				}
			}
			flightService.setMap(flightMap);
		}
	}
}
