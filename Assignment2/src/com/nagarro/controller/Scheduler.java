package com.nagarro.controller;

import static com.nagarro.constants.NumericConstants.DELAY;
import static com.nagarro.constants.NumericConstants.START_TIME;

import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.inputoutput.CSVFileReader;
import com.nagarro.inputoutput.UserOutput;

/**
 * The Class Scheduler.
 */
public class Scheduler extends TimerTask {

	/** The csv filereader. */
	CSVFileReader csvFilereader = new CSVFileReader();

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		try {
			csvFilereader.read();
		} catch (Exception e) {
			UserOutput.display(e.getMessage());
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
