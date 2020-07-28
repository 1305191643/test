package com.chen;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.chen.dao.UserDao;
import com.chen.entry.User;
import com.chen.rabbitmqutil.PageInfo;
import com.chen.service.UserService;
import com.github.pagehelper.PageHelper;
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UsetTest {
	
	private Logger logger = LoggerFactory.getLogger(UsetTest.class);
	 
	@Autowired
	private UserService userService;
	
	@Before
    public void init() {
        System.out.println("开始测试-----------------");
    }
 
  

	
	@Test
	public void testFindByPage() {
		  /* PageHelper.startPage(1, 10);
		   Map map=new HashMap();
		   List<User> users=userDao.selectAll(map);
		   PageInfo<User> pageInfo = new PageInfo<>(users);
		   logger.debug(pageInfo.toString());*/
		 PageInfo<User> pageInfo=userService.selectAll(1, 10);
		 logger.info("111111111111111111111111111111111");
		 logger.info(pageInfo.toString());
		 //logger.debug("11111111111111");
		 ArrayList list=new ArrayList();
		 Map map=new HashMap();
	}

	  @After
	    public void after() {
	        System.out.println("测试结束-----------------");
	    }


}
