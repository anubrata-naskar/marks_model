package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CreateTable;
import dao.DatabaseDAO;

import java.sql.Connection;

import java.util.List;

import dao.CreateTable;
import dao.DatabaseDAO;

import transferobjects.*;

public class MySQLRepository implements StorageRepository{
	Connection cn;
	CreateTable ct = new CreateTable();
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
	    String str = "SELECT MAX(marks_obtained) AS highest_marks, full_marks, paper_title, th_pr_ia, half, roll FROM `marks` WHERE `paper_code` = ? AND `year` = ?";

	    try (PreparedStatement ps = cn.prepareStatement(str)) {
	        ps.setString(1, paper_code);
	        ps.setInt(2, year);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                h = rs.getInt("highest_marks");

	                // You can access other columns as well
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
	public void create_connection() throws SQLException{
		DatabaseDAO create_con = new DatabaseDAO();
		 cn = create_con.getConnection();
		if(cn != null)
			System.out.println("Connection create successfull");
		else
			System.out.println("Connection failed");
		}
	
	public void addDetails(List<Student> studentList) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addDetails(int sem, String semYear, List<String> rollList) {
		
		try {
			create_connection();
			ct.create_table();
			for(String roll:rollList) {
				//System.out.println(roll);
				PreparedStatement stm = cn.prepareStatement("SELECT * from `sem_details` where sem_number like ? and sem_year like ? and roll like ?" );
				stm.setInt(1, sem);
				stm.setString(2, semYear);
				stm.setString(3, roll);
				ResultSet res = stm.executeQuery();
				res.next();
				if(!res.next()) {
					PreparedStatement stmt = cn.prepareStatement("INSERT INTO `sem_details`(sem_number,sem_year,roll) VALUES (?,?,?)");
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
	
	private void updateDetails(int rowCount) {
		if(rowCount<=0) {
			System.out.print("problem");
		}
		
	}
	//problem_sweta
	
	@Override
	public void addMarksDetails(List<Marks> marks) {
		try {
			create_connection();
			ct.create_table();
			PreparedStatement stmt;
			for(Marks mark : marks) {
				PreparedStatement stm = cn.prepareStatement("SELECT s_id from `sem_details` where sem_year like ? and roll like ?" );
				stm.setString(1, mark.getSemYear());
				stm.setString(2, mark.getRoll());
				ResultSet res = stm.executeQuery();
				res.next();
				if(res.next()) {
					stmt = cn.prepareStatement("INSERT INTO `marks` VALUES (?,?,?,?,?,?,?,?)");
					stmt.setString(1, mark.getPaperCode());
					stmt.setString(2, mark.getSemYear());
					System.out.println("sid:"+res.getString(1));
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
}
