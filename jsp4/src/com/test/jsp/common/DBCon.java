package com.test.jsp.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {

	public static void main(String[] args) {
		Connection con;
		String url = "jdbc:mysql://localhost:3307/jsp4";
		String id = "root";
		String pwd = "2340";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("접속이 잘 되었습니다.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
