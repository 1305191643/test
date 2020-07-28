package com.chen.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.UserDao;
import com.chen.entry.User;
import com.chen.rabbitmqutil.PageInfo;
import com.chen.service.UserService;
import com.github.pagehelper.PageHelper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao  userDao;

	@Override
	public PageInfo<User> selectAll(Integer page,Integer size) {
		PageHelper.startPage(page, size);
		   Map map=new HashMap();
		   List<User> users=userDao.selectAll(map);
		   PageInfo<User> pageInfo = new PageInfo<>(users);
		   return pageInfo;
	}
	
	

}
