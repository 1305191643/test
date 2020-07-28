package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;


@Service
public class UserService {
	
	    @Autowired
	    UserMapper userMapper;
	    
	    
	    public List<User> getUserAll(){
	        return userMapper.getUserAll();
	    }
	    
	    
	    public void  deleteUserById(Integer userId) {
	    	Integer i=userMapper.deleteUserById(userId);
	    	//System.out.println(i);
	    }
	    
	    @Transactional
	    public void  updateUserById(User user,Integer deleteId) {
	    	try {
	    		
		    	Integer userId=deleteId;
		    	Integer j=userMapper.deleteUserById(userId);
		    	System.out.println(j);
		    	Integer i=userMapper.updateUserById(user);
		    	System.out.println(i);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
	    }
	    
	    public void   insertUser() {
	    	User user=new User();
	    	user.setName("333");
	    	Integer i=userMapper.insertUser(user);
	    	System.out.println(user.getId());
	    }
	    
	    

}
