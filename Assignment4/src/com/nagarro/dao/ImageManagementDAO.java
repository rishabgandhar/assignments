package com.nagarro.dao;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.nagarro.model.Image;
import com.nagarro.model.User;

public interface ImageManagementDAO {

	public User authenticateUser(String userName, String password)
			throws Exception;

	public Set<Image> getUserImageList(HttpServletRequest request)
			throws Exception;

	public void saveUserImage(Image image) throws Exception;

	public void deleteUserImage(int imageId, int userId) throws Exception;

	public void editUserImage(int imageid, int userId, String imageName,
			long size, String relativepath) throws Exception;

	public void editUserImage(int imageid, int userId, String imageName)
			throws Exception;

	public long getImagesSize(User user) throws Exception;
}
