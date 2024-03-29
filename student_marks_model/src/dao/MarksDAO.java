package dao;

import java.sql.SQLException;
import java.util.List;

import repository.*;
import transferobjects.*;

public class MarksDAO implements MarksDetailsDAO {
	//repository -> to fetch data from database
	BaseRepository ur = new UserRepository(new MySQLRepository());
	BaseRepository mr = new MarksRepository(new MySQLRepository());
	
	@Override
	public Student get(String course) throws SQLException {
		Student stu = null;
		stu = mr.getAllDetails("T91","CSE",214031,"b.tech.(computer science & engineering) sem v 2023");
		return stu;
	}
	
	public Marks highestMarks(String paper_code, int year) throws SQLException {
		Marks marks = null;
		marks = mr.highestMarks(paper_code,year);
		return marks;
	}
	public Marks avgMarks(String paper_code, int year) throws SQLException {
		Marks marks = null;
		marks = mr.avgMarks(paper_code,year);
		return marks;
	}
//	public Marks qualify_perc(String paper_code, int year) throws SQLException {
//		Marks marks = null;
//		marks = mr.qualify_perc(paper_code,year);
//		return marks;
//	}
	
	//marks-sheet generate
	public Marks marks_sheet_gen(String roll, String year, String sem) throws SQLException {
		Marks marks = null;
		marks = mr.marks_sheet_gen(roll,year,sem);
		return marks;
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

	public Marks getAbsentStudent(String paperCode, String year) throws SQLException{
		Marks marks = null;
		marks = mr.getAbsentStudent(paperCode, year);
		return marks;
	}

	public Marks getFailedStudents(String subCode, String examType, String year, int passPerc) throws SQLException{
		Marks marks = null;
		marks = mr.getFailedStudents(subCode, examType, year, passPerc);
		return marks;
	}

	@Override
	public Marks qualify_perc(String paper_code, int year) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
