package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transferobjects.Marks;
import transferobjects.Student;

public class UserRepository extends BaseRepository{
	public UserRepository(StorageRepository storage) {
		super(storage);
	}

	@Override
	public void storeMarks(ArrayList<String> a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void storeDetails(List<Marks> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeStudentDetails(List<Student> studentList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeSem(int semNum, String semYear, List<String> rollList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int highestMarks(String s, int n) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
