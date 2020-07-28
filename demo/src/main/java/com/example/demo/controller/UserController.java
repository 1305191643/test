package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("user")
public class UserController {
	
	
	
	
	@Autowired
    private UserService userService;
 
    @RequestMapping("getUserAll")
    public List<User> getUserAll(){
        return userService.getUserAll();
    }
    
    @RequestMapping("getPageUserAll")
    public  Object getUserAll(int  page,int rows){
    	PageHelper.startPage(page,rows);
    	List<User> list=userService.getUserAll();
    	PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
    }
    
    @RequestMapping("deleteUserById")
    public void deleteUserById(Integer userId){
        userService.deleteUserById(userId);
    }
    
    @RequestMapping("updateUserById")
    public void updateUserById(User user,Integer deleteId){
        userService.updateUserById(user,deleteId);
    }

    @RequestMapping("insertUser")
    public void insertUser(){
        userService.insertUser();
    }


}
