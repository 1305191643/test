package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface  UserMapper {
	
	List<User> getUserAll();
	 
	Integer  deleteUserById(Integer userId);
	
	Integer  updateUserById(User user);
	
	Integer insertUser(User user);

}
