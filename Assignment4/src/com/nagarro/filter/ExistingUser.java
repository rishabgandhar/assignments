package com.nagarro.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.constants.ServletConstants;
import com.nagarro.model.User;
import com.nagarro.service.ImageManagementService;
import com.nagarro.service.ImageManagementServiceImpl;
import com.nagarro.util.SizeConverter;

public class ExistingUser implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		try {
			User user = (User) request.getSession().getAttribute(
					ServletConstants.USER_ATTRIBUTE);
			if (user != null) {
				ImageManagementService imageService = ImageManagementServiceImpl
						.getInstance();
				long totalImageSize = imageService.getImagesSize(user);
				String sizeToDisplay = SizeConverter
						.convertSize(totalImageSize);
				request.setAttribute(ServletConstants.IMAGE_SIZE_ATTRIBUTE,
						sizeToDisplay);
				request.setAttribute(ServletConstants.IMAGE_LIST_ATTRIBUTE,
						user.getImages());
				request.getRequestDispatcher("./Home.jsp").forward(request,
						response);
			} else {
				arg2.doFilter(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("./Error.jsp").forward(request,
					response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
