package com.nagarro.controller;

import static com.nagarro.constants.ConsoleMessages.FILE_NOT_FOUND;
import static com.nagarro.constants.NumericConstants.DELAY;
import static com.nagarro.constants.NumericConstants.START_TIME;

import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.inputoutput.CSVReader;
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
	CSVReader reader = new CSVReader();

	@Override
	public void run() {
		try {
			reader.read();
		} catch (Exception e) {
			e.printStackTrace();
			UserOutput.display(FILE_NOT_FOUND);
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
