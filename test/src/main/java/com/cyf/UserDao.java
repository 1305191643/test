package com.cyf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDao {
	
	
	public Map queryUserById(int id) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 2.读取配置文件的内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);

		// 3.使用sqlSessionFactory对象，创建SqlSession对象
				SqlSession sqlSession = sqlSessionFactory.openSession();
				// 4.使用sqlSession对象，调用方法执行
				Object user = sqlSession.selectOne("queryUserById", id);
				System.out.println(user);
				// 5.释放资源
				sqlSession.close();

		
		return (Map) user;
		
	}

}
