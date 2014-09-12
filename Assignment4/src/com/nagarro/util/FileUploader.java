package com.nagarro.util;

import java.io.DataInputStream;
import java.io.FileOutputStream;

import com.nagarro.constants.ServletConstants;

public class FileUploader {

	/**
	 * @param request
	 *            Receives reference of the request object of Servlet/JSP
	 * @param absolutefolderpath
	 *            Receives absolutepath of folder where file is to be uploaded
	 * @param userId
	 *            Receives upload filename to be set on Server side
	 * @throws Exception
	 */

	public static String savefile(String contentType, DataInputStream in,
			int formDataLength, String absolutefolderpath, int userId)
			throws Exception {
		byte dataBytes[] = new byte[formDataLength];
		int byteRead = 0;
		int totalBytesRead = 0;
		if (formDataLength == 0) {
			return ServletConstants.NO_FILE;
		}
		while (totalBytesRead < formDataLength) {
			byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
			totalBytesRead += byteRead;
		}
		String file = new String(dataBytes);
		String saveFile;

		saveFile = file.substring(file.indexOf("filename=\"") + 10);
		saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
		saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
				saveFile.indexOf("\""));
		if (saveFile == null || saveFile.equals("")) {
			return ServletConstants.NO_FILE;
		}
		String ext = saveFile.substring(saveFile.lastIndexOf(".") + 1);
		System.out.println(ext);
		if (!(ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg")
				|| ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("bmp"))) {
			throw new Exception("Invalid Image File");
		}
		int lastIndex = contentType.lastIndexOf("=");

		String boundary = contentType.substring(lastIndex + 1,
				contentType.length());
		int pos;
		pos = file.indexOf("filename=\"");
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		pos = file.indexOf("\n", pos) + 1;
		int boundaryLocation = file.indexOf(boundary, pos) - 4;
		int startPos = ((file.substring(0, pos)).getBytes()).length;
		int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

		FileOutputStream fileOut = new FileOutputStream(absolutefolderpath
				+ "\\" + userId + "_" + saveFile);
		fileOut.write(dataBytes, startPos, (endPos - startPos));
		fileOut.flush();
		fileOut.close();
		return saveFile;
	}
}
