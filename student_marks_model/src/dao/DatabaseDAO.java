package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDAO {
	  private String url = "jdbc:mysql://localhost:3306/stu_project";
	    private String username = "root";
	    private String password = "";
	    private Connection connection = null;
	    public Connection getConnection() throws SQLException {
				connection = DriverManager.getConnection(url,username,password);
	    	return connection;
	    }
}
