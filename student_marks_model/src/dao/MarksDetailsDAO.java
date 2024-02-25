package dao;

import java.sql.SQLException;
import java.util.List;

import transferobjects.Marks;
import transferobjects.Student;

public interface MarksDetailsDAO {
	Student get(String course) throws SQLException;
	List<Student> getAll() throws SQLException;
	int save(Student student) throws SQLException;
	int insert(Student student) throws SQLException;
	public Marks highestMarks(String paper_code, int year) throws SQLException;
	public Marks avgMarks(String paper_code, int year) throws SQLException;
	public Marks qualify_perc(String paper_code, int year) throws SQLException;
}
