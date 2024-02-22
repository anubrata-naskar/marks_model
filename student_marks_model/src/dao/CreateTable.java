package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

// token  - 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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// token  - 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
public class CreateTable {
	public void create_table() {
        try {
            // JDBC URL, username, and password of MySQL server
            String url = "jdbc:mysql://localhost:3306/stu_project";
            String user = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, user, password);
            java.sql.Statement statement = connection.createStatement();

            String createStudentsTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                  "roll VARCHAR(255)," +
                  "dept VARCHAR(255)," +
                  "PRIMARY KEY (roll))";
            
            statement.executeUpdate(createStudentsTableQuery);
            
            String createSemDetailsTableQuery = "CREATE TABLE IF NOT EXISTS sem_details (" +
                    "s_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "sem_number INT," +
                    "sem_year INT," +
                    "roll VARCHAR(255)," +
                    "FOREIGN KEY (roll) REFERENCES students(roll))";
            
            statement.executeUpdate(createSemDetailsTableQuery);
            statement.executeUpdate("ALTER TABLE sem_details AUTO_INCREMENT=1001;");

          
            String createMarksTableQuery = "CREATE TABLE IF NOT EXISTS marks (" +
                  "paper_code VARCHAR(255)," +
                  "year INT," +
                  "s_id INT," +
                  "full_marks INT," +
                  "marks_obtained INT," +
                  "paper_title VARCHAR(255)," +
                  "th_pr_ia VARCHAR(255)," +
                  "half VARCHAR(255)," +
                  "roll VARCHAR(255)," +
                  "PRIMARY KEY (paper_code, year, s_id)," +
                  "FOREIGN KEY (s_id) REFERENCES sem_details(s_id)," +
                  "FOREIGN KEY (roll) REFERENCES students(roll))";
            
            statement.executeUpdate(createMarksTableQuery);

            System.out.println("Tables created successfully!");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
