package com.chen.dao;

import java.util.List;
import java.util.Map;

import com.chen.entry.User;

public interface UserDao {
	
	public List<User> getUsers();
	
	public void insertUser(User user);

	

}
