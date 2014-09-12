package com.nagarro.constants;

public class ServletConstants {

	private ServletConstants() {
	}

	public static String IMAGE_SIZE_ATTRIBUTE = "imageSize";
	public static String IMAGE_LIST_ATTRIBUTE = "imageList";
	public static String IMAGE_ID_PARAMETER = "imageId";
	public static String IMAGE_ID_PARAMETER_2 = "imageid";
	public static String USERNAME_PARAMETER = "username";
	public static String PASSWORD_PARAMETER = "password";
	public static String IMAGE_NAME_PARAMETER = "name";
	public static String USER_ATTRIBUTE = "user";
	public static String CATALINA_BASE = "catalina.base";
	public static String WEBAPP_PATH = "/webapps/Images/";
	public static String ABSOLUTE_PATH = "D:/Softwares/java soe software/java/apache-tomcat-7.0.27/apache-tomcat-7.0.27/webapps/";
	public static String IMAGE_RELATIVE_PATH = "../Images/";
	public static String NO_FILE_SELECTED = "No File Selected";
	public static String INVALID_IMAGE_FILE = "Invalid Image File";
	public static String FILE_SIZE_EXCEEDED = "File Size Exceeded";
	public static String MAX_SIZE_EXCEEDED = "Maximum Size Exceeded";
	public static String NO_FILE = "no file";

	public static int FILE_SIZE_LIMIT = 1024 * 1024;
	public static int MAX_SIZE_LIMIT = 10 * 1024 * 1024;
}
