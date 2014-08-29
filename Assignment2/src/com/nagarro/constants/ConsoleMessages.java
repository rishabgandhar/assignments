package com.nagarro.constants;

/**
 * The Class ConsoleMessages.
 */
public class ConsoleMessages {

	/**
	 * Instantiates a new console messages.
	 */
	private ConsoleMessages() {
	}

	/** The Constant WELCOME_USER. */
	public static final String WELCOME_USER = "Welcome to Flight Search System";

	/** The Constant ASK_OTHER_QUERY. */
	public static final String ASK_OTHER_QUERY = "Do you want to search for more flights (Y/N) :";

	/** The Constant ENTER_DEP_STN. */
	public static final String ENTER_DEP_STN = "Enter the Departure Station : ";

	/** The Constant ENTER_ARR_STN. */
	public static final String ENTER_ARR_STN = "Enter the Arrival Station : ";

	/** The Constant ENTER_FLIGHT_DATE. */
	public static final String ENTER_FLIGHT_DATE = "Enter the Flight Date(DD-MM-YYYY) : ";

	/** The Constant ENTER_FLIGHT_CLASS. */
	public static final String ENTER_FLIGHT_CLASS = "Enter the Flight Class(E-Economic B-Business)(E/B): ";

	/** The Constant ENTER_SORT_OPTION. */
	public static final String ENTER_SORT_OPTION = "Enter the sorting option\na.Fare\nb.Fare and Flight Duration: ";

	/** The Constant WRONG_DEP_STN. */
	public static final String WRONG_DEP_STN = "Please Enter a valid Departure Station";

	/** The Constant WRONG_ARR_STN. */
	public static final String WRONG_ARR_STN = "Please Enter a valid Arrival Station";

	/** The Constant WRONG_CLASS. */
	public static final String WRONG_CLASS = "Please Enter a valid Flight Class";

	/** The Constant WRONG_SORT_OPTN. */
	public static final String WRONG_SORT_OPTN = "Please Enter a valid Sorting Option";

	/** The Constant WRONG_DATE. */
	public static final String WRONG_DATE = "Please Enter a valid Sorting Option";

	/** The Constant WRONG_OPTION. */
	public static final String WRONG_OPTION = "Please Enter a valid Option(Y/N) ";

	/** The Constant NO_FLIGHT. */
	public static final String NO_FLIGHT = "Sorry, No matching flight found";

	/** The Constant SAME_ARR_DEP. */
	public static final String SAME_ARR_DEP = "Arrival And Departure Stations cannot be same. Please Enter valid data again";

	/** The Constant FILE_NOT_FOUND. */
	public static final String FILE_NOT_FOUND = "Connection with the database has been lost. Please try after some time.";

	/** The Constant CONSOLE_DISCONNECT. */
	public static final String CONSOLE_DISCONNECT = "Connection with the user input has been lost. Please try after some time.";

	/** The Constant GOODBYE. */
	public static final String GOODBYE = "Thanks For visiting !!";

	/** The Constant INVAILD_FLIGHT_DETAILS. */
	public static final String INVAILD_FLIGHT_DETAILS = "Invalid Flight Details in row : ";

	/** The Constant INVALID_FOLDER_LOCATION. */
	public static final String INVALID_FOLDER_LOCATION = "Invalid folder path given for CSV Files";
}