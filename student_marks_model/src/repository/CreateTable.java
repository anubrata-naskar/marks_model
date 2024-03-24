package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.xdevapi.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import connections.CreateConnectionMySQL;
import java.sql.Connection;


public class CreateTable {
	public void create_table() {
        try {
        	Connection cn;
        	CreateConnectionMySQL create_con = new CreateConnectionMySQL();
    		cn = create_con.getConnection();

            java.sql.Statement statement = cn.createStatement();

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
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
