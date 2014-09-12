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
 * Servlet implementation class UserLogin
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request
				.getParameter(ServletConstants.USERNAME_PARAMETER);
		String password = request
				.getParameter(ServletConstants.PASSWORD_PARAMETER);
		ImageManagementService imageService = ImageManagementServiceImpl
				.getInstance();
		try {
			User user = imageService.authenticateUser(userName, password);
			if (user == null) {
				request.setAttribute("WRONG_USER", "true");
				request.getRequestDispatcher("./JSP/UserLogin.jsp").forward(
						request, response);
			} else {
				request.getSession().setAttribute(
						ServletConstants.USER_ATTRIBUTE, user);
				long totalImageSize = imageService.getImagesSize(user);
				String sizeToDisplay = SizeConverter
						.convertSize(totalImageSize);
				request.setAttribute(ServletConstants.IMAGE_SIZE_ATTRIBUTE,
						sizeToDisplay);
				request.setAttribute(ServletConstants.IMAGE_LIST_ATTRIBUTE,
						user.getImages());
				request.getRequestDispatcher("./JSP/Home.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("./JSP/Error.jsp").forward(request,
					response);
		}
	}
}
