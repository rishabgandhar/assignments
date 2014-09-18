package com.nagarro.controller;

import static com.nagarro.constants.NumericConstants.DELAY;
import static com.nagarro.constants.NumericConstants.START_TIME;

import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.inputoutput.CSVFileReader;
import com.nagarro.inputoutput.UserOutput;

/**
 * This class is the scheduler class and runs after every 10 seconds to read new
 * CSV Files.
 * 
 * @author rishabgandhar
 *
 */
public class Scheduler extends TimerTask {

	/** The csv filereader. */
	CSVFileReader csvFilereader = new CSVFileReader();

	@Override
	public void run() {
		try {
			csvFilereader.read();
		} catch (Exception e) {
			UserOutput.display(e.getMessage());
		}
	}

	/**
	 * Read new CSV files.
	 */
	public void readFiles() {
		try {
			Timer timer = new Timer();
			timer.schedule(this, START_TIME, DELAY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
