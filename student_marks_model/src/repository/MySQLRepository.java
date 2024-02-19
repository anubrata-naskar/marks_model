package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CreateTable;
import dao.DatabaseDAO;

import java.sql.Connection;

import transferobjects.*;

public class MySQLRepository implements StorageRepository{
	Connection cn;
	CreateTable ct = new CreateTable();
	public String addDeltails() {
		String str = "add details";
		return str;
	}
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException{
		create_connection();
		ct.create_table();
		Student stu = null;
	    String sec = section.toLowerCase();
	    String str = "SELECT * FROM `" + sec + "` WHERE `coll` LIKE '" + coll + "' AND `cate` LIKE '" + cate + "' AND `number` = " + number;
	    PreparedStatement ps = cn.prepareStatement(str);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String coll2 = rs.getString("coll");
			String cate2 = rs.getString("cate");
			String paper_code = rs.getString("paper_code");
			int number2 = rs.getInt("number");
			int marks = rs.getInt("marks");
			
			stu = new Student("b.tech.(computer science & engineering) sem v 2023", 
					paper_code, "IA", "", coll2, cate2, number2, 100, marks);
		} 
	    return stu;
	}
//	public static void main(String args[]) {
//		String str = getAllDetails("T91","CSE",214031,"B.TECH.(COMPUTER SCIENCE & ENGINEERING) SEM V 2023");
//		System.out.println(str);
//	}
	
	public void create_connection() throws SQLException{
		DatabaseDAO create_con = new DatabaseDAO();
		 cn = create_con.getConnection();
		if(cn != null)
			System.out.println("Connection create successfull");
		else
			System.out.println("Connection failed");
		}
}
