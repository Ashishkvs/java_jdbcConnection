package com.imagegrafia.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	static String url="jdbc:mysql://localhost:3306/hibernateDemo?user=root&password=admin&useSSL=false";
	String userName="root";
	String pass="admin";
	public static void main(String[] args) throws Exception {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		 Connection conn=DriverManager.getConnection(url);
		Statement stmt=conn.createStatement();
		
		stmt.executeUpdate("insert into employee values (23,'ksasy@gmail.com','kumara')");
		
		ResultSet resultSet=stmt.executeQuery("select * from employee");
		
		while(resultSet.next()) {
			//System.out.println(resultSet.getMetaData());
			System.out.println(resultSet.getString(2));
		}
		conn.close();
	}
}
