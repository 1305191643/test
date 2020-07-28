package com.chen.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chen.entry.User;
import com.github.pagehelper.Page;

@Repository
public interface UserDao {
	
	public List<User> getUsers();
	
	public void insertUser(User user);
	
	
	public List<User> selectAll(Map map);

	

}
