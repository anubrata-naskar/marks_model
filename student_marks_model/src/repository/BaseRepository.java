package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.Marks;
import transferobjects.Student;
import transferobjects.User;

public abstract class BaseRepository {
	protected StorageRepository storage;
	protected BaseRepository(StorageRepository storage) {
		this.storage = storage;
	}
	
	public abstract void storeDetails(List<Marks> m) throws SQLException; 
	public abstract void storeMarks(ArrayList<String> a);
	public abstract Student getAllDetails(String coll, String cate, int number, String section) throws SQLException;
	public abstract void storeStudentDetails(List<Student> studentList) throws SQLException;
	public abstract void storeSem(int semNum, String semYear, List<String> rollList) throws SQLException;
	public abstract Marks highestMarks(String s, int n) throws SQLException;
	public abstract Marks avgMarks(String s, int n) throws SQLException;
	public abstract Marks marks_sheet_gen(String roll, String year, String sem) throws SQLException ;
	public abstract Marks getAbsentStudent(String paperCode, String year) throws SQLException;
	public abstract Marks getFailedStudents(String subCode, String examType, String year, int passPerc) throws SQLException;

	public abstract User check(String username,String pass);
	public abstract User verify(String mail);
	public abstract void modifyP(String encrypted_pass, String mail);
	public abstract void storedata(String name, String email, String username, String encrypted_pass);
}
