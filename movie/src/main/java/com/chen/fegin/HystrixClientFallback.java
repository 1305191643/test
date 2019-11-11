package com.chen.fegin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.chen.entry.User;



@Component
public class HystrixClientFallback implements PromotionClient {

 

@Override
public List<User> releasePromotion(@RequestParam("name") String name) {
	 System.out.println(name+"fefdwqffffffffffffffffffffffffffffffffffffffffffffff");
	 User user = new User();
	 user.setId(5);
	 user.setName("刘德华");
	 List l=new ArrayList<User>();
	 l.add(user);
	return l;
}

@Override
public void insert(User user) {
	// TODO Auto-generated method stub
	
}



}