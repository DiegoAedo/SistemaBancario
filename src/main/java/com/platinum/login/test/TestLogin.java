package com.platinum.login.test;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Connection;





import com.platinum.login.database.*;


public class TestLogin {
	
	@Test
	public void getConnectionTest() throws Exception {
        Connection dbConnection = (Connection) JDBCDataSource.getConnection();
        assertNotNull("connection should be successfull.", dbConnection);
 
    }
	
}
