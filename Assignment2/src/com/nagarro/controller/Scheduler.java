package com.nagarro.controller;

import static com.nagarro.constants.ConsoleMessages.FILE_NOT_FOUND;
import static com.nagarro.constants.NumericConstants.DELAY;
import static com.nagarro.constants.NumericConstants.START_TIME;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.inputoutput.CSVReader;
import com.nagarro.inputoutput.UserOutput;

/**
 * The Class Scheduler.
 */
public class Scheduler extends TimerTask {

	/** The reader. */
	CSVReader reader = new CSVReader();

	/**
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		try {
			reader.read();
		} catch (FileNotFoundException e) {
			UserOutput.display(FILE_NOT_FOUND);
		} catch (IOException e) {
			UserOutput.display(FILE_NOT_FOUND);
		}
	}

	/**
	 * Read files.
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
