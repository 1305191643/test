package com.cyf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class UserJdbc {
	
	public String getUser() {
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet set = null;
		String result="";
		try {
			// 1.��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.�������ݿ�����Ӷ���
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
			// 3.����sql���
			String sql = "select * from user where id = ?";
			// 4.����statement����
			psmt = con.prepareStatement(sql);
			// 5.���ò���
			psmt.setInt(1, 1);
			// 6.ִ��
			set = psmt.executeQuery();
			// 7.��������
			while (set.next()) {
				result="�û�Id��" + set.getInt("id") + ",�û����ƣ�" + set.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//8.�ͷ���Դ
				if (set != null)set.close();
				if (psmt != null)psmt.close();
				if (con != null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	
	 public static void main(String[] args) {  
		  /*ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
		  for (int i = 0; i < 10; i++) {  
		   final int index = i;  
		   try {  
		    Thread.sleep(index * 1000);  
		   } catch (InterruptedException e) {  
		    e.printStackTrace();  
		   }  
		   cachedThreadPool.execute(new Runnable() {  
		    public void run() {  
		     System.out.println(index);  
		    }  
		   });  
		  }  */
		 
		 /*ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);  
		  for (int i = 0; i < 10; i++) {  
		   final int index = i;  
		   fixedThreadPool.execute(new Runnable() {  
		    public void run() {
		    	 System.out.println(index);  
		     try {  
		      System.out.println(index);  
		      Thread.sleep(2000);  
		     } catch (InterruptedException e) {  
		      e.printStackTrace();  
		     }  
		    }  
		   });  
		  }  
		 }  */
		 
		 ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();  
		  for (int i = 0; i < 10; i++) {  
		   final int index = i;  
		   singleThreadExecutor.execute(new Runnable() {  
		    public void run() {
		    	System.out.println(index);  
		     /*try {  
		      System.out.println(index);  
		      Thread.sleep(2000);  
		     } catch (InterruptedException e) {  
		      e.printStackTrace();  
		     }  */
		    }  
		   });  
		  }  
	 }
}
