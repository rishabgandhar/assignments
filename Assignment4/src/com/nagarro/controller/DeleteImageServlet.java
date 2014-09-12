package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.constants.ServletConstants;
import com.nagarro.model.User;
import com.nagarro.service.ImageManagementService;
import com.nagarro.service.ImageManagementServiceImpl;
import com.nagarro.util.SizeConverter;

/**
 * Servlet implementation class DeleteImageServlet
 */
public class DeleteImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int imageId = Integer.parseInt(request
				.getParameter(ServletConstants.IMAGE_ID_PARAMETER_2));
		User user = (User) request.getSession().getAttribute(
				ServletConstants.USER_ATTRIBUTE);
		int userId = user.getId();
		ImageManagementService imageManagementService = ImageManagementServiceImpl
				.getInstance();
		try {
			imageManagementService.deleteUserImage(imageId, userId);
			String totalSize = SizeConverter.convertSize(imageManagementService
					.getImagesSize(user));
			request.setAttribute(ServletConstants.IMAGE_SIZE_ATTRIBUTE,
					totalSize);
			request.setAttribute(ServletConstants.IMAGE_LIST_ATTRIBUTE,
					imageManagementService.getUserImageList(request));
			request.getRequestDispatcher("./JSP/Home.jsp").forward(request,
					response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.getRequestDispatcher("./JSP/Error.jsp").forward(request,
					response);
		}
	}

}
