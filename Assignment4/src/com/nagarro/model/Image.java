package com.nagarro.model;

import java.io.Serializable;

public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private long size;
	private String path;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Image() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		Image obj2 = (Image) obj;
		if ((this.name == obj2.getName()) && (this.path.equals(obj2.getPath()))) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int tmp = 0;
		tmp = (name + path).hashCode();
		return tmp;
	}
}
