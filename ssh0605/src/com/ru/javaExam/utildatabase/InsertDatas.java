package com.ru.javaExam.utildatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 项目名称：ssh0605
 * 类描述：向MySQL数据库批量插入数据
 * 创建人：ru
 * 创建时间：2013-8-14 上午10:16:17
 * 修改人：ru
 * 修改时间：2013-8-14 上午10:16:17
 * 修改备注：
 * @since  jdk1.7
 * @version 1.0
 */
public class InsertDatas {

	String classDriver = "com.mysql.jdbc.Driver";
	String dbConnection = "jdbc:mysql://localhost:3306/ssh";
	String userName = "root";
	String password = "123456";
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	@Test
	public void insert() throws SQLException{
		int count = 1;
		String sql = "INSERT INTO `stuscore`(`name`,`score`,`date`) VALUES('ru123',100,'2013-08-14 17:45:16')";
		try {
			//1.加载驱动
			Class.forName(classDriver);
			
			//2.连接数据库
			connection = DriverManager.getConnection(dbConnection,userName,password);
			
			//2.1启动事务
			connection.setAutoCommit(false);
			
			//3.创建表达式
			statement = connection.createStatement();
			
			//4.执行指令
			for(int i = 0; i < 1000; i++){
				System.out.println(count++);
				statement.execute(sql);
			}
			
			//2.2提交事务
			connection.commit();
			
		} catch (Exception e) {
			//跑异常后，事务回滚
			connection.rollback();
			e.printStackTrace();
		}finally{
			//关闭资源
			if(statement !=null){
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			if(connection != null){
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}
