import static org.junit.Assert.*;

import org.junit.Test;

import com.platinum.login.database.JDBCDataSource;

import org.junit.Test;
import java.sql.Connection;
public class Prueba {

	@Test
	   public void getConnectionTest() throws Exception {
        Connection dbConnection = (Connection) JDBCDataSource.getConnection();
        assertNotNull("connection should be successfull.", dbConnection);
 
    }

}
