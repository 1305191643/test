package com.chen.service;

import java.util.List;
import java.util.Map;

import com.chen.entry.User;
import com.chen.rabbitmqutil.PageInfo;

public interface UserService {
	public PageInfo<User> selectAll(Integer page,Integer size);

}
