package repository;

import java.sql.SQLException;
import java.util.ArrayList;

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
}
