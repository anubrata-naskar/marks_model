package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transferobjects.Marks;
import transferobjects.Student;

public abstract class BaseRepository {
	protected StorageRepository storage;
	protected BaseRepository(StorageRepository storage) {
		this.storage = storage;
	}
	
	public abstract void storeDetails(List<Marks> m); 
	public abstract void storeMarks(ArrayList<String> a);
	public abstract Student getAllDetails(String coll, String cate, int number, String section) throws SQLException;
	public abstract void storeStudentDetails(List<Student> studentList);
	public abstract void storeSem(int semNum, String semYear, List<String> rollList);
	public abstract Marks highestMarks(String s, int n) throws SQLException;
}
