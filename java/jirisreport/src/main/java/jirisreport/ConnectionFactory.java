package jirisreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.intersystems.jdbc.IRISDriver");
        return DriverManager.getConnection(url,user,password);
	}

}
