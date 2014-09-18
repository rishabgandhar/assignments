package com.nagarro.inputoutput;

import static com.nagarro.constants.CSVReaderConstants.FILE_EXTENSION;
import static com.nagarro.constants.CSVReaderConstants.FILE_PATH;
import static com.nagarro.constants.CSVReaderConstants.FIRST_LINE;
import static com.nagarro.constants.CSVReaderConstants.SPLITTER;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.constants.ConsoleMessages;
import com.nagarro.constants.GenericConstants;
import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;
import com.nagarro.service.FlightServiceImpl;
import com.nagarro.util.FlightDataValidation;

/**
 * The Class CSVFileReader which reads the CSV files from the drive.
 */
public class CSVReader {

	/** The fileMap containing list of all read files with date of reading. */
	private Map<File, Date> fileMap = new HashMap<>();

	/**
	 * Reads the CSV File.
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
								Flight flight = Flight.getInstance(airlineData,
										"util");
								flights.add(flight);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					bufferedReader.close();
				}
			}
			flightService.setFlightMap(flights);
		} else {
			throw new Exception(ConsoleMessages.INVALID_FOLDER_LOCATION);
		}
	}

	/**
	 * Checks if a file is valid and modified.
	 *
	 * @param file
	 *            the file
	 * @return true, if file is valid and modified
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
