package com.youtube.utility;

import java.sql.*;

public class MySqlConnection {
	
	public static void main(String args[]) {
		Connection con = null;
		con = getDBConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
		} catch (Exception e) {

		}
	}

	public static Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "aditya");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
