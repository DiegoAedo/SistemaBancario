package com.platinum.login.database;

import java.sql.Connection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.util.Properties;
public class JDBCDataSource {
	
    private static JDBCDataSource datasource;
    private static Properties prop = null;
    
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
            datasource.cpds.setInitialPoolSize(10);
            datasource.cpds.setAcquireIncrement(10);
            datasource.cpds.setMaxPoolSize(100);
            datasource.cpds.setMinPoolSize(10);
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
