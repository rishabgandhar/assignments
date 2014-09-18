package com.nagarro.main;

import com.nagarro.controller.Controller;
import com.nagarro.controller.Scheduler;

/**
 * This class is the initial point of the program
 * 
 * @author rishabgandhar
 *
 */
public class Initializer {
	public static void main(String args[]) {
		new Scheduler().readFiles();
		new Controller().start();
	}
}
