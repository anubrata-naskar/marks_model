package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transferobjects.Marks;
import transferobjects.Student;
import transferobjects.User;

public class UserRepository extends BaseRepository{
	

	public UserRepository(StorageRepository storage) {
		super(storage);
	}
	
	
	public User check(String username,String pass) {
		User che=storage.checkLogin(username,pass);
		return che;
	}
	
	
	public User verify(String mail) {
		User mave=storage.verifyMail(mail);
		return mave;
	}


	@Override
	public void modifyP(String encrypted_pass, String mail) {
		storage.modifyPassword(encrypted_pass,mail);
	}
	
	

	@Override
	public void storedata(String name, String email, String username, String encrypted_pass) {
		storage.storeAdminDetails(name,email,username,encrypted_pass);
	}


	//unnecessary

	@Override
	public void storeDetails(List<Marks> m) throws SQLException {
		// TODO Auto-generated method stub
		
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
	public void storeStudentDetails(List<Student> studentList) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeSem(int semNum, String semYear, List<String> rollList) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marks highestMarks(String s, int n) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marks avgMarks(String s, int n) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marks marks_sheet_gen(String roll, String year, String sem) throws SQLException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Marks getAbsentStudent(String paperCode, String year) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marks getFailedStudents(String subCode, String examType, String year, int passPerc) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
