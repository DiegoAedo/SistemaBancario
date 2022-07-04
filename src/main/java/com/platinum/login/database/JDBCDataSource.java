package com.platinum.login.database;

import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {
	
    private static JDBCDataSource datasource;
    private JDBCDataSource() {
    }
    private ComboPooledDataSource cpds = null;
  
    public static JDBCDataSource getInstance() {
        if (datasource == null) {
 
            datasource = new JDBCDataSource();
            datasource.cpds = new ComboPooledDataSource();
            try {
                datasource.cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }
            datasource.cpds.setJdbcUrl("jdbc:mysql://localhost:3306/login");
            datasource.cpds.setUser("root");
            datasource.cpds.setPassword("root");

        }
        return datasource;
    }

    public static Connection getConnection() throws Exception {
        return getInstance().cpds.getConnection();
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }
    

}
