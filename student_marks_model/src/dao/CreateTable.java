package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class CreateTable {
	public void create_table() {
        try {
            // JDBC URL, username, and password of MySQL server
            String url = "jdbc:mysql://localhost:3306/stu_project";
            String user = "root";
            String password = "";

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            java.sql.Statement statement = connection.createStatement();

            // Create 'students' table
            String createStudentsTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                    "coll VARCHAR(255)," +
                    "cate VARCHAR(255)," +
                    "number INT," +
                    "dept VARCHAR(255)," +
                    "PRIMARY KEY (coll, cate, number))";
            statement.executeUpdate(createStudentsTableQuery);

            // Create 'sem_details' table
            String createSemDetailsTableQuery = "CREATE TABLE IF NOT EXISTS sem_details (" +
                    "s_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "sem_number INT," +
                    "sem_year INT," +
                    "coll VARCHAR(255)," +
                    "cate VARCHAR(255)," +
                    "number INT," +
                    "FOREIGN KEY (coll, cate, number) REFERENCES students(coll, cate, number))";
            statement.executeUpdate(createSemDetailsTableQuery);

            // Create 'marks' table
            String createMarksTableQuery = "CREATE TABLE IF NOT EXISTS marks (" +
                    "paper_code VARCHAR(255)," +
                    "year INT," +
                    "s_id INT," +
                    "full_marks INT," +
                    "marks_obtained INT," +
                    "paper_title VARCHAR(255)," +
                    "th_pr_ia VARCHAR(255)," +
                    "half VARCHAR(255)," +
                    "coll VARCHAR(255)," +
                    "cate VARCHAR(255)," +
                    "number INT," +
                    "PRIMARY KEY (paper_code, year, s_id)," +
                    "FOREIGN KEY (s_id) REFERENCES sem_details(s_id)," +
                    "FOREIGN KEY (coll, cate, number) REFERENCES students(coll, cate, number))";
            statement.executeUpdate(createMarksTableQuery);

            System.out.println("Tables created successfully!");

            // Close the connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
