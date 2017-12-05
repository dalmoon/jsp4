package com.test.jsp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCon {

	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3307/jsp4";
		String id = "root";
		String pwd = "2340";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("접속이 잘 되었습니다.");
			String sql = "select * from user_info";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString("userno")+",");
				System.out.print(rs.getString("username")+",");
				System.out.print(rs.getString("userid")+",");
				System.out.print(rs.getString("userpwd")+",");
				System.out.print(rs.getString("userage")+",");
				System.out.print(rs.getString("dino")+",");
				System.out.print(rs.getString("useraddress"));
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con = null;
			}
		}
	}
}
