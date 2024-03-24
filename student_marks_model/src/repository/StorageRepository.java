package repository;

import java.sql.SQLException;
import java.util.List;
import transferobjects.*;
import connections.*;

interface StorageRepository {
	public String addDetails();
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException;
	public void addDetails(List<Student> studentList) throws SQLException;
	public void addDetails(int sem, String semYear, List<String> rollList) throws SQLException;
	public void addMarksDetails(List<Marks> marks) throws SQLException;
	public Marks highestMarks(String s, int n) throws SQLException;
	public Marks avgMarks(String paper_code, int year) throws SQLException;
	public Marks qualify_perc(String paper_code, int year) throws SQLException;
}
