package repository;

import java.sql.SQLException;
import java.util.ArrayList;

import transferobjects.Student;

public class MarksRepository extends BaseRepository{
	public MarksRepository(StorageRepository storage) {
		super(storage);
	}
	public void storeMarks(ArrayList<String> myArrayList) {
		String str = storage.addDeltails();
		System.out.println(str);
	}
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException {
		Student stu = storage.getAllDetails(coll, cate, number, section);
		return stu;
	}
}
