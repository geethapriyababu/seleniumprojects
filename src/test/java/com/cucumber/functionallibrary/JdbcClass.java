package com.cucumber.functionallibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JdbcClass {
	
	public static ResultSet jdbcConnection() throws Throwable {
		Connection c = null;
		ResultSet rs=null;
		 
			Class.forName("com.mysql.jdbc.Driver");

			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/automationpractice_schema", "root", "");
			PreparedStatement ps = c.prepareStatement("select * from automationpractice_schema.create_account;");
			rs = ps.executeQuery();
			 ArrayList<String> sqlData = new ArrayList<String>(); 
			while (rs.next()) {
				sqlData.add(rs.getString(1));
				sqlData.add(rs.getString(2));
				sqlData.add(rs.getString(3));
				sqlData.add(rs.getString(4));
				sqlData.add(rs.getString(5));
				sqlData.add(rs.getString(6));
				sqlData.add(rs.getString(7));
				sqlData.add(rs.getString(8));
				sqlData.add(rs.getString(9));
				sqlData.add(rs.getString(10));
				sqlData.add(rs.getString(11));
				sqlData.add(rs.getString(12));
				sqlData.add(rs.getString(13));
				sqlData.add(rs.getString(14));
				sqlData.add(rs.getString(15));
				sqlData.add(rs.getString(16));
			}
			return rs;
		}
	
		
	}



