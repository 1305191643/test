package com.cyf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServelt extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		
		
		System.out.println("初始化");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("我是get");
		System.out.println(req.getParameter("123"));
		System.out.println(req.getContextPath());
		//重定向
		//resp.sendRedirect(req.getContextPath() + "/index.jsp"); 
		//转发
		//req.getRequestDispatcher("/index.jsp").forward(req, resp);
		Cookie coo = new Cookie("key", "value");//创建一个键值对的cookie对象
		coo.setMaxAge(60*60*24*7);//设置cookie的生命周期
		resp.addCookie(coo);//添加到response中
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
