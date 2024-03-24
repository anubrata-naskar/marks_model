package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.DatabaseDAO;
import repository.*;
import transferobjects.*;


public class CreateConnectionMySQL{
	private String url = "jdbc:mysql://localhost:3306/stu_project";
    private String username = "root";
    private String password = "";
    private Connection connection = null;
    
    public Connection getConnection() throws SQLException {
			connection = DriverManager.getConnection(url,username,password);
    	return connection;
    }
}
