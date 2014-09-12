package com.nagarro.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.constants.ServletConstants;
import com.nagarro.model.Image;
import com.nagarro.model.User;
import com.nagarro.service.ImageManagementService;
import com.nagarro.service.ImageManagementServiceImpl;
import com.nagarro.util.FileUploader;
import com.nagarro.util.SizeConverter;

/**
 * Servlet implementation class ImageUploader
 */
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImageManagementService imageManagementService = ImageManagementServiceImpl
			.getInstance();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String totalSize = null;
		Set<Image> imageList = null;
		try {
			User user = (User) request.getSession().getAttribute(
					ServletConstants.USER_ATTRIBUTE);
			totalSize = SizeConverter.convertSize(imageManagementService
					.getImagesSize(user));
			String absolutepath = new File(
					System.getProperty(ServletConstants.CATALINA_BASE))
					.getAbsolutePath();
			absolutepath = absolutepath.replace("\\", "/");
			absolutepath += ServletConstants.WEBAPP_PATH;
			String contentType = request.getContentType();
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				DataInputStream in = new DataInputStream(
						request.getInputStream());
				int formDataLength = request.getContentLength();
				if (formDataLength == 0) {
					throw new Exception(ServletConstants.NO_FILE_SELECTED);
				}
				if (formDataLength > ServletConstants.FILE_SIZE_LIMIT) {
					throw new Exception(ServletConstants.FILE_SIZE_EXCEEDED);
				}
				long totalFileSize = imageManagementService.getImagesSize(user);
				if (totalFileSize + formDataLength > (ServletConstants.MAX_SIZE_LIMIT)) {
					throw new Exception(ServletConstants.MAX_SIZE_EXCEEDED);
				}
				String fileName = FileUploader.savefile(contentType, in,
						formDataLength, absolutepath, user.getId());
				String relativepath = ServletConstants.IMAGE_RELATIVE_PATH
						+ user.getId() + "_" + fileName;
				long size = formDataLength;
				Image image = new Image();
				image.setName(fileName);
				image.setSize(size);
				image.setPath(relativepath);
				image.setUser(user);
				imageManagementService.saveUserImage(image);
				totalSize = SizeConverter.convertSize(imageManagementService
						.getImagesSize(user));
				imageList = imageManagementService.getUserImageList(request);
			}
		} catch (Exception e) {
			if (e.getMessage().contains(ServletConstants.FILE_SIZE_EXCEEDED)) {
				request.setAttribute("MAX_FILE_SIZE", "true");
			} else if (e.getMessage().contains(
					ServletConstants.MAX_SIZE_EXCEEDED)) {
				request.setAttribute("MAX_IMAGE_SIZE", "true");
			} else if (e.getMessage().contains(
					ServletConstants.INVALID_IMAGE_FILE)) {
				request.setAttribute("INVALID_IMAGE", "true");
			} else if (e.getMessage().contains(
					ServletConstants.NO_FILE_SELECTED)) {
				request.setAttribute("INVALID_FILE", "true");
			} else {
				request.getRequestDispatcher("./JSP/Error.jsp").forward(
						request, response);
			}
			e.printStackTrace();
		}
		request.setAttribute(ServletConstants.IMAGE_SIZE_ATTRIBUTE, totalSize);
		request.setAttribute(ServletConstants.IMAGE_LIST_ATTRIBUTE, imageList);
		request.getRequestDispatcher("./JSP/Home.jsp").forward(request,
				response);
	}
}
