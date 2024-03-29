package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connections.CreateConnectionMySQL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import transferobjects.*;

public class MySQLRepository implements StorageRepository{
	Connection cn;
	CreateTable ct = new CreateTable();
	
//	public void create_connection() throws SQLException{
//		DatabaseDAO create_con = new DatabaseDAO();
//		 cn = create_con.getConnection();
//		if(cn != null)
//			System.out.println("Connection create successfull");
//		else
//			System.out.println("Connection failed");
//		}
	
	public void create_connection() throws SQLException{
		CreateConnectionMySQL create_con = new CreateConnectionMySQL();
		cn = create_con.getConnection();
	}
	public String addDeltails() {
		String str = "add details";
		return str;
	}
	
//	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException{
//		create_connection();
//		ct.create_table();
//		Student stu = null;
//	    String sec = section.toLowerCase();
//	    String str = "SELECT * FROM `" + sec + "` WHERE `coll` LIKE '" + coll + "' AND `cate` LIKE '" + cate + "' AND `number` = " + number;
//	    PreparedStatement ps = cn.prepareStatement(str);
//		ResultSet rs = ps.executeQuery();
//		
//		if(rs.next()) {
//			String coll2 = rs.getString("coll");
//			String cate2 = rs.getString("cate");
//			String paper_code = rs.getString("paper_code");
//			int number2 = rs.getInt("number");
//			int marks = rs.getInt("marks");
//			
//			stu = new Student("b.tech.(computer science & engineering) sem v 2023", 
//					paper_code, "IA", "", coll2, cate2, number2, 100, marks);
//		} 
//	    return stu;
//	}
//	public static void main(String args[]) {
//		String str = getAllDetails("T91","CSE",214031,"B.TECH.(COMPUTER SCIENCE & ENGINEERING) SEM V 2023");
//		System.out.println(str);
//	}
	
	
	public Marks highestMarks(String paper_code, int year) throws SQLException {
	    create_connection();
	    ct.create_table();   

	    Marks marks = null;
	    int h = 0;
	    
	    String str = "SELECT marks_obtained, full_marks, paper_title, th_pr_ia, half, roll FROM `marks` WHERE `paper_code` = ? AND `year` = ? ORDER BY marks_obtained DESC LIMIT 1";
	    System.out.println("himsr");
	    try (PreparedStatement ps = cn.prepareStatement(str)) {
	        ps.setString(1, paper_code);
	        ps.setInt(2, year);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	            	
	                h = rs.getInt("marks_obtained");

	                int fullMarks = rs.getInt("full_marks");
	                String paperTitle = rs.getString("paper_title");
	                String exam_type = rs.getString("th_pr_ia");
	                String roll = rs.getString("roll");
	                String yearS = String.valueOf(year);
	                String fullMarksS = String.valueOf(fullMarks);
	                String highestMarks = String.valueOf(h);
	                marks = new Marks(paper_code, yearS, fullMarksS, highestMarks, paperTitle, exam_type, roll); 
	                
	            }
	        }
	    }
	    return marks;
	}

	
	public Marks avgMarks(String paper_code, int year) throws SQLException {
	    create_connection();
	    ct.create_table();  
	    Marks marks = null;
	    double averageMarks = 0.0;
	    
	    String str = "SELECT AVG(marks_obtained) AS average_marks, full_marks, paper_title, th_pr_ia, half, roll FROM `marks` WHERE `paper_code` = ? AND `year` = ?";

	    try (PreparedStatement ps = cn.prepareStatement(str)) {
	        ps.setString(1, paper_code);
	        ps.setInt(2, year);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                averageMarks = rs.getDouble("average_marks");
	                //System.out.println(averageMarks);

	                // You can access other columns as well
	                int fullMarks = rs.getInt("full_marks");
	                String paperTitle = rs.getString("paper_title");
	                String exam_type = rs.getString("th_pr_ia");
	                // If you want to include a placeholder for the roll since it's not available in AVG operation
	                String roll = rs.getString("roll"); 

	                String yearS = String.valueOf(year);
	                String fullMarksS = String.valueOf(fullMarks);
	                String averageMarksS = String.valueOf(averageMarks);
	                marks = new Marks(paper_code, yearS, fullMarksS, averageMarksS, paperTitle, exam_type, roll); 
	            }
	        }
	    }

	    return marks;
	}


	public Marks qualify_perc(String paper_code, int year) throws SQLException {
	    create_connection();
	    ct.create_table();   

	    Marks marks = null;
	    String percentageQualified = null;

	    String str = "SELECT CONCAT(ROUND((COUNT(CASE WHEN m.marks_obtained >= 25 THEN 1 END) / COUNT(*)) * 100),'%') AS percentage_qualified FROM `marks` m INNER JOIN `sem_details` sd ON m.s_id = sd.s_id INNER JOIN `students` s ON m.roll = s.roll WHERE m.paper_code = ?  AND m.year = ?";

	    try (PreparedStatement ps = cn.prepareStatement(str)) {
	        ps.setString(1, paper_code);
	        ps.setInt(2, year);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                percentageQualified = rs.getString("percentage_qualified");
	                //System.out.println(percentageQualified);
	                String yearS = String.valueOf(year);
	                marks = new Marks(paper_code, yearS, "null", percentageQualified, "null", "null", "null");               
	            }
	        }
	    }
	    return marks;
	}


	@Override
	public Marks marks_sheet_gen(String roll, String year, String sem) throws SQLException {
		create_connection();
	    ct.create_table();  
	    
	    Marks marks = new Marks(); // Initialize the Marks object
	    List<Marks> marksList = new ArrayList<>(); // List to store mark details for each paper
	    
	    String str = "SELECT marks.paper_code, marks.paper_title, marks.full_marks, marks.th_pr_ia, marks.marks_obtained FROM marks INNER JOIN sem_details ON sem_details.s_id=marks.s_id WHERE marks.roll LIKE ? AND sem_details.sem_number = ? AND sem_details.sem_year = ?";
	    try (PreparedStatement ps = cn.prepareStatement(str)) {
	        ps.setString(1, roll);
	        ps.setString(2, sem);
	        ps.setString(3, year);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                String paperCode = rs.getString("paper_code");
	                String paperTitle = rs.getString("paper_title");
	                int fullMarks = rs.getInt("full_marks");
	                String fullMarksS = String.valueOf(fullMarks);
	                int marksObt = rs.getInt("marks_obtained");
	                String marksObtS = String.valueOf(marksObt);
	                String exam_type = rs.getString("th_pr_ia");
	                
	                Marks details = new Marks(paperCode, year, fullMarksS, marksObtS, paperTitle, exam_type, roll);
	                marksList.add(details);
	            }
	        }
	    }
	    
	    marks.setMarksList(marksList); 
	    return marks;
	}
	
	@Override
	public Marks getAbsentStudent(String paperCode, String year) throws SQLException{
		create_connection();
	    ct.create_table();  
	    
	    Marks marks = new Marks(); // Initialize the Marks object
	    List<Marks> marksList = new ArrayList<>(); // List to store mark details for each paper
	    
	    String str = "SELECT roll, paper_title, full_marks, th_pr_ia, marks_obtained FROM marks  WHERE paper_code LIKE ? AND year = ? AND marks_obtained = ?";
	    try (PreparedStatement ps = cn.prepareStatement(str)) {
	        ps.setString(1, paperCode);
	        ps.setString(2, year);
	        ps.setInt(3, 0);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	            	String roll = rs.getString("roll");
	                String paperTitle = rs.getString("paper_title");
	                int fullMarks = rs.getInt("full_marks");
	                String fullMarksS = String.valueOf(fullMarks);
	                String exam_type = rs.getString("th_pr_ia");
	                
	                Marks details = new Marks(paperCode, year, fullMarksS, "0", paperTitle, exam_type, roll);
	                marksList.add(details);
	            }
	        }
	    }
	    
	    marks.setMarksList(marksList); 
	    return marks;
	}
	
	@Override
	public Marks getFailedStudents(String subCode, String examType, String year, int passPerc) throws SQLException{
		create_connection();
	    ct.create_table();  
	    
	    Marks marks = new Marks(); // Initialize the Marks object
	    List<Marks> marksList = new ArrayList<>(); // List to store mark details for each paper
	    
	    String str = "SELECT roll, paper_title, full_marks, th_pr_ia, marks_obtained FROM marks WHERE paper_code LIKE ? AND th_pr_ia = ? AND year= ? AND marks_obtained < ?";
	    try (PreparedStatement ps = cn.prepareStatement(str)) {
	        ps.setString(1, subCode);
	        ps.setString(2, examType);
	        ps.setString(3, year);
	        ps.setInt(4, passPerc);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	            	String roll = rs.getString("roll");
	                String paperTitle = rs.getString("paper_title");
	                int fullMarks = rs.getInt("full_marks");
	                String fullMarksS = String.valueOf(fullMarks);
	                String exam_type = rs.getString("th_pr_ia");
	                String obMarks = rs.getString("marks_obtained");
	                Marks details = new Marks(subCode, year, fullMarksS, obMarks, paperTitle, exam_type, roll);
	                marksList.add(details);
	            }
	        }
	    }
	    
	    marks.setMarksList(marksList); 
	    return marks;
	}
	
	public void addDetails(List<Student> studentList) throws SQLException {
		try {
			create_connection();
			ct.create_table();
			PreparedStatement stmt;
			for(Student std : studentList) {
				PreparedStatement stm = cn.prepareStatement("SELECT * from students where roll like ? " );
				stm.setString(1, std.getRoll());
				ResultSet res = stm.executeQuery();
				if(!res.next()) {
					stmt = cn.prepareStatement("INSERT INTO `students` VALUES (?,?)");
					stmt.setString(1, std.getRoll());
					stmt.setString(2, std.getDept());
					int rowCount = stmt.executeUpdate();
				}	
			}
			System.out.println("add student details");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
	
public void addDetails(int sem, String semYear, List<String> rollList) throws SQLException{
		
		try {
			create_connection();
			ct.create_table();
			for(String roll:rollList) {
				//System.out.println(roll);
				PreparedStatement stm = cn.prepareStatement("SELECT * from sem_details where sem_number like ? and sem_year like ? and roll like ?" );
				stm.setInt(1, sem);
				stm.setString(2, semYear);
				stm.setString(3, roll);
				ResultSet res = stm.executeQuery();
				if(!res.next()) {
					PreparedStatement stmt = cn.prepareStatement("INSERT INTO sem_details(sem_number,sem_year,roll) VALUES (?,?,?)");
					stmt.setInt(1, sem);
					stmt.setString(2, semYear);
					stmt.setString(3, roll);
					int rowCount = stmt.executeUpdate();
					updateDetails(rowCount);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateDetails(int rowCount) throws SQLException{
		if(rowCount<=0) {
			System.out.print("problem");
		}
		
	}
	//problem_sweta
	
	@Override
	public void addMarksDetails(List<Marks> marks) throws SQLException{
		try {
			create_connection();
			ct.create_table();
			PreparedStatement stmt;
			for(Marks mark : marks) {
				PreparedStatement stm = cn.prepareStatement("SELECT s_id from sem_details where sem_year like ? and roll like ?" );
				stm.setString(1, mark.getSemYear());
				stm.setString(2, mark.getRoll());
				ResultSet res = stm.executeQuery();
				if(res.next()) {
					PreparedStatement stm1 = cn.prepareStatement("SELECT * from marks where paper_code like ? and year like ? and s_id like ?" );
					stm1.setString(1, mark.getPaperCode());
					stm1.setInt(2, Integer.parseInt(mark.getSemYear()));
					stm1.setInt(3, res.getInt(1));
					ResultSet res1 = stm1.executeQuery();
					if(!res1.next()) {
						stmt = cn.prepareStatement("INSERT INTO marks VALUES (?,?,?,?,?,?,?,'null',?)");
						stmt.setString(1, mark.getPaperCode());
						stmt.setString(2, mark.getSemYear());
						System.out.println("sid:"+res.getInt(1));
						stmt.setString(3, res.getString(1));
						stmt.setString(4, mark.getFullMark());
						int obMark;
						if(mark.getObMark().equalsIgnoreCase("xx") || mark.getObMark().equalsIgnoreCase("absent")) {
							obMark = 00;
						}
						else {
							obMark =Integer.parseInt(mark.getObMark());
						}
						stmt.setInt(5, obMark);
						stmt.setString(6, mark.getPaperTitle());
						stmt.setString(7, mark.getExamType());
						stmt.setString(8, mark.getRoll());
						int rowCount = stmt.executeUpdate();
						updateDetails(rowCount);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String addDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User checkLogin(String uname,String passl) {
		    ct.create_table(); 
		boolean userFound =false;
		try {
			CreateConnectionMySQL obj=new CreateConnectionMySQL();
			Connection connection=obj.getConnection();
			Statement statement = connection.createStatement();
			

			String sql = "select username,password from admin where username='" + uname + "'";
			ResultSet resultSet = statement.executeQuery(sql);

			userFound = false;

			while (resultSet.next()) {
				String loadedUsername = resultSet.getString("username");
				String loadedPassword = resultSet.getString("password");

				if (uname.equals(loadedUsername) && passl.equals(loadedPassword)) {
					userFound = true;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		User u=new User(userFound);
		return u;
		//return userFound;
	}
	
	public User verifyMail(String mail) {
		    ct.create_table(); 
		boolean userFound = false;

		try {
			CreateConnectionMySQL obj=new CreateConnectionMySQL();
			Connection connection=obj.getConnection();
			Statement statement = (Statement) connection.createStatement();
			String sql = "SELECT email FROM admin WHERE email='" + mail + "'";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String loadedemail = resultSet.getString("email");

				if (mail.equals(loadedemail)) {
					userFound = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		User u=new User(userFound);
		return u;
	}
	@Override
	public void modifyPassword(String encrypted_pass, String mail) {
		    ct.create_table(); 
		try {
			CreateConnectionMySQL obj=new CreateConnectionMySQL();
			Connection connection=obj.getConnection();
			Statement statement = connection.createStatement();

			String sql = "UPDATE admin SET password='" + encrypted_pass + "' WHERE email='" + mail + "'";
			int rowsAffected = statement.executeUpdate(sql);

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Password Updated Successfully..!");
			} else {
				JOptionPane.showMessageDialog(null, "Failed to update password. User not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}
	@Override
	public void storeAdminDetails(String name, String email, String username, String encrypted_pass) {
		    ct.create_table(); 
		try {
			CreateConnectionMySQL obj=new CreateConnectionMySQL();
			Connection connection=obj.getConnection();
			Statement statement = (Statement) connection.createStatement();
			String sql = "insert into admin (name, email, username, password) values ('" + name + "', '" + email
					+ "', '" + username + "', '" + encrypted_pass + "')";

			int rowsAffected = statement.executeUpdate(sql);

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Admin data inserted successfully in database..!!");
			} else {
				JOptionPane.showMessageDialog(null, "Insertion failed!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
}
