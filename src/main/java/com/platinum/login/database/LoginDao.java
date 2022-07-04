package com.platinum.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.platinum.login.bean.*;

public class LoginDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/login";
	private String dbUname ="root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	
	public void loadDriver(String dbDriver) {
		
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
		con= DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public boolean validate(LoginBean loginBean) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		String sql ="SELECT * FROM ejecutivo WHERE rut_ejecutivo = ? and nombre = ? ";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getPassword());
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return status;
		
	}

}
