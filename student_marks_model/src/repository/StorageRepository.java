package repository;

import java.sql.SQLException;
import java.util.List;
import transferobjects.*;

interface StorageRepository {
	public String addDetails();
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException;
	public void addDetails(List<Student> studentList) throws SQLException;
	public void addDetails(int sem, String semYear, List<String> rollList) throws SQLException;
	public void addMarksDetails(List<Marks> marks) throws SQLException;
	public Marks highestMarks(String s, int n) throws SQLException;
	public Marks avgMarks(String paper_code, int year) throws SQLException;
	public Marks marks_sheet_gen(String roll, String year, String sem) throws SQLException;
	public Marks getAbsentStudent(String paperCode, String year) throws SQLException;
	public Marks getFailedStudents(String subCode, String examType, String year, int passPerc) throws SQLException;
}
