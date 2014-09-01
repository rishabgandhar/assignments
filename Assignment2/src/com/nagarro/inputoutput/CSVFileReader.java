package com.nagarro.inputoutput;

import static com.nagarro.constants.CSVReaderConstants.FILE_EXTENSION;
import static com.nagarro.constants.CSVReaderConstants.FILE_PATH;
import static com.nagarro.constants.CSVReaderConstants.FIRST_LINE;
import static com.nagarro.constants.CSVReaderConstants.SPLITTER;
import static com.nagarro.constants.CharConstants.BUSINESS;
import static com.nagarro.constants.NumericConstants.BUSINESS_FARE_INCREMENT;
import static com.nagarro.constants.NumericConstants.CLASS_INDEX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.constants.CSVReaderConstants;
import com.nagarro.constants.ConsoleMessages;
import com.nagarro.constants.GenericConstants;
import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;
import com.nagarro.service.FlightServiceImpl;
import com.nagarro.util.DateParser;
import com.nagarro.util.FlightDataValidation;

/**
 * The Class CSVFileReader.
 */
public class CSVFileReader {

	/** The files. */
	private Map<File, Date> fileMap = new HashMap<>();

	/**
	 * Gets the single instance of CSVFileReader.
	 *
	 * @param data
	 *            the data
	 * @param flightClassIndex
	 *            the flight class index
	 * @return single instance of CSVFileReader
	 */
	public static Flight getInstance(String data[], int flightClassIndex) {
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
		if (data[CLASS_INDEX].charAt(flightClassIndex) == BUSINESS) {
			flight.setFlightClass(CSVReaderConstants.BUSINESS);
			flight.setFlightFare(flight.getFlightFare()
					+ flight.getFlightFare() * BUSINESS_FARE_INCREMENT);
		} else {
			flight.setFlightClass(CSVReaderConstants.ECONOMIC);
		}
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
	 * @throws Exception
	 *             the exception
	 */
	public void read() throws Exception {
		FlightService flightService = FlightServiceImpl.getInstance();
		List<Flight> flights = new ArrayList<>();
		File file = new File(FILE_PATH);
		if (file.exists() && file.isDirectory()) {
			File[] list = file.listFiles();
			for (File currentFile : list) {
				if (isValidAndModified(currentFile)) {
					String airlineName = currentFile.getName().substring(0,
							currentFile.getName().indexOf("."));
					FileReader fr = new FileReader(currentFile);
					BufferedReader bufferedReader = new BufferedReader(fr);
					String line = GenericConstants.INITIALIZE_STRING;
					int rowNo = 0;
					while ((line = bufferedReader.readLine()) != null) {
						if (line.startsWith(FIRST_LINE)) {
							continue;
						}
						line += "|" + airlineName;
						rowNo++;
						String airlineData[] = line.split(SPLITTER);
						try {
							if (FlightDataValidation.validFlightData(
									airlineData, rowNo, airlineName)) {
								for (int index = 0; index < airlineData[CLASS_INDEX]
										.length(); index++) {
									Flight flight = getInstance(airlineData,
											index);
									flights.add(flight);
								}
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					fileMap.put(currentFile,
							new Date(currentFile.lastModified()));
					bufferedReader.close();
				}
			}
			flightService.setList(flights);
		} else {
			throw new Exception(ConsoleMessages.INVALID_FOLDER_LOCATION);
		}
	}

	/**
	 * Checks if is valid and modified.
	 *
	 * @param file
	 *            the file
	 * @return true, if is valid and modified
	 */
	public boolean isValidAndModified(File file) {
		boolean isValidAndModified = false;
		if ((file.getName().endsWith(FILE_EXTENSION))
				&& ((!fileMap.containsKey(file) || fileMap.get(file).before(
						new Date(file.lastModified()))))) {
			isValidAndModified = true;
		}
		return isValidAndModified;
	}
}
