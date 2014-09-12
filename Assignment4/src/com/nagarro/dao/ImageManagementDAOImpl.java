package com.nagarro.dao;

import java.io.File;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.nagarro.constants.ServletConstants;
import com.nagarro.model.Image;
import com.nagarro.model.User;
import com.nagarro.util.HibernateUtility;

public class ImageManagementDAOImpl implements ImageManagementDAO {

	@Override
	public User authenticateUser(String userName, String password)
			throws Exception {
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		Criterion c1 = Restrictions.eq(ServletConstants.USERNAME_PARAMETER,
				userName);
		Criterion c2 = Restrictions.eq(ServletConstants.PASSWORD_PARAMETER,
				password);
		LogicalExpression andExpression = Restrictions.and(c1, c2);
		criteria.add(andExpression);
		User user = (User) criteria.uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	@Override
	public Set<Image> getUserImageList(HttpServletRequest request)
			throws Exception {
		User currentUser = (User) request.getSession().getAttribute(
				ServletConstants.USER_ATTRIBUTE);
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, currentUser.getId());
		session.getTransaction().commit();
		return user.getImages();
	}

	@Override
	public void saveUserImage(Image image) {
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		session.save(image);
		session.getTransaction().commit();
	}

	@Override
	public void deleteUserImage(int imageId, int userId) throws Exception {
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		Image image = (Image) session.get(Image.class, imageId);
		new File(ServletConstants.ABSOLUTE_PATH + image.getPath().substring(3))
				.delete();
		if (image.getUser().getId() == userId) {
			session.delete(image);
		} else {
			session.getTransaction().rollback();
			throw new Exception("Error");
		}
		session.getTransaction().commit();
	}

	@Override
	public void editUserImage(int imageid, int userId, String imageName,
			long size, String relativepath) throws Exception {
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		Image image = (Image) session.get(Image.class, imageid);
		new File(image.getPath()).delete();
		if (image.getUser().getId() == userId) {
			image.setName(imageName);
			image.setPath(relativepath);
			image.setSize(size);
		} else {
			session.getTransaction().rollback();
			throw new Exception("Error");
		}
		session.getTransaction().commit();
	}

	@Override
	public void editUserImage(int imageid, int userId, String imageName)
			throws Exception {
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		Image image = (Image) session.get(Image.class, imageid);
		if (image.getUser().getId() == userId) {
			image.setName(imageName);
		} else {
			session.getTransaction().rollback();
			throw new Exception("Error");
		}
		session.getTransaction().commit();
	}

	@Override
	public long getImagesSize(User currentUser) throws Exception {
		Session session = HibernateUtility.getSessionfactory()
				.getCurrentSession();
		session.beginTransaction();
		String hql_query = "select SUM(image.size) from Image image where image.user.id="
				+ currentUser.getId();
		Object sum = session.createQuery(hql_query).uniqueResult();
		long totalSize = 0;
		if (sum != null) {
			totalSize = (long) sum;
		}
		session.getTransaction().commit();
		return totalSize;
	}
}
