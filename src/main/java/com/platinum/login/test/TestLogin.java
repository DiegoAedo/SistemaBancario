package com.platinum.login.test;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.platinum.login.bean.LoginBean;
import com.platinum.login.database.*;


public class TestLogin {
	
	@Test
	public void getConnectionTest() throws Exception {
        Connection dbConnection = (Connection) JDBCDataSource.getConnection();
        assertNotNull("connection should be successfull.", dbConnection);
 
    }
	
}
