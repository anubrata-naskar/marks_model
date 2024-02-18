package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repository.*;
import transferobjects.*;

public class MarksDAO implements MarksDetailsDAO {
	//repository -> to fetch data from database
	BaseRepository ur = new UserRepository(new MySQLRepository());
	BaseRepository mr = new MarksRepository(new MySQLRepository());
	
	Connection cn;
	
	CreateTable ct = new CreateTable();
	
	
	@Override
	public Student get(String course) throws SQLException {
		create_connection();
		ct.create_table();
		
		Student stu = null;
		String str = mr.getAllDetails("T91","CSE",214031,"b.tech.(computer science & engineering) sem v 2023");
		//String str = "SELECT * FROM `b.tech.(computer science & engineering) sem v 2023` WHERE `coll` LIKE 'T91' AND `cate` LIKE 'CSE' AND `number` = 214031";
		//System.out.println(str);
		
		
		PreparedStatement ps = cn.prepareStatement(str);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String coll = rs.getString("coll");
			String cate = rs.getString("cate");
			String paper_code = rs.getString("paper_code");
			int number = rs.getInt("number");
			int marks = rs.getInt("marks");
			
			stu = new Student("b.tech.(computer science & engineering) sem v 2023", 
					paper_code, "IA", "", coll, cate, number, 100, marks);
		} 
		return stu;
	}
	@Override
	public List<Student> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int save(Student student) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(Student student) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void create_connection() throws SQLException{
	DatabaseDAO create_con = new DatabaseDAO();
	 cn = create_con.getConnection();
	if(cn != null)
		System.out.println("Connection create successfull");
	else
		System.out.println("Connection failed");
	}
	
	
//	//transferobjects
//	public static void main(String args[]) {
//	Marks marks = new Marks();
//	Student student = new Student();
//	
//	private ArrayList<String> myArrayList;
//	public void uploadDetails(ArrayList<String> stringList) {
//		this.myArrayList = stringList;
//		mr.storeMarks(myArrayList);
//	}
}
