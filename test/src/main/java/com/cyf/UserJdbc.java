package com.cyf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserJdbc {
	
	public String getUser() {
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet set = null;
		String result="";
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建数据库的连接对象
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
			// 3.定义sql语句
			String sql = "select * from user where id = ?";
			// 4.创建statement对象
			psmt = con.prepareStatement(sql);
			// 5.设置参数
			psmt.setInt(1, 1);
			// 6.执行
			set = psmt.executeQuery();
			// 7.处理结果集
			while (set.next()) {
				result="用户Id：" + set.getInt("id") + ",用户名称：" + set.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//8.释放资源
				if (set != null)set.close();
				if (psmt != null)psmt.close();
				if (con != null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}

}
