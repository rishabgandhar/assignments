package com.nagarro.service;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.nagarro.dao.ImageManagementDAO;
import com.nagarro.dao.ImageManagementDAOImpl;
import com.nagarro.model.Image;
import com.nagarro.model.User;

public class ImageManagementServiceImpl implements ImageManagementService {

	private ImageManagementDAO imageManagementDao = new ImageManagementDAOImpl();

	private static ImageManagementService imageManagementService = new ImageManagementServiceImpl();

	private ImageManagementServiceImpl() {
	}

	public static ImageManagementService getInstance() {
		return imageManagementService;
	}

	@Override
	public User authenticateUser(String userName, String password)
			throws Exception {
		return imageManagementDao.authenticateUser(userName, password);
	}

	@Override
	public Set<Image> getUserImageList(HttpServletRequest request)
			throws Exception {
		return imageManagementDao.getUserImageList(request);
	}

	@Override
	public void saveUserImage(Image image) throws Exception {
		imageManagementDao.saveUserImage(image);
	}

	@Override
	public void deleteUserImage(int imageId, int userId) throws Exception {
		imageManagementDao.deleteUserImage(imageId, userId);
	}

	@Override
	public void editUserImage(int imageid, int userId, String imageName,
			long size, String relativepath) throws Exception {
		imageManagementDao.editUserImage(imageid, userId, imageName, size,
				relativepath);
	}

	@Override
	public void editUserImage(int imageid, int userId, String imageName)
			throws Exception {
		imageManagementDao.editUserImage(imageid, userId, imageName);
	}

	@Override
	public long getImagesSize(User user) throws Exception {
		return imageManagementDao.getImagesSize(user);
	}

}
