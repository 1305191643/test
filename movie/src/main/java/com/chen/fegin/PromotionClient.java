package com.chen.fegin;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chen.entry.User;

@FeignClient(name = "user", fallback = HystrixClientFallback.class)
public interface PromotionClient {

	@RequestMapping(value = "/user",method = RequestMethod.GET)
    List<User>  releasePromotion(@RequestParam("name") String name) ;
	
	
	@RequestMapping(value = "/insert",method = RequestMethod.GET)
    void  insert(User user) ;
	
}
