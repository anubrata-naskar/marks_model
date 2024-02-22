package repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transferobjects.Marks;
import transferobjects.Student;

public class MarksRepository extends BaseRepository{
	public MarksRepository(StorageRepository storage) {
		super(storage);
	}
	public void storeMarks(ArrayList<String> myArrayList) {
		String str = storage.addDetails();
		System.out.println(str);
	}
	public Student getAllDetails(String coll, String cate, int number, String section) throws SQLException {
		Student stu = storage.getAllDetails(coll, cate, number, section);
		return stu;
	}
	@Override
	public void storeDetails(List<Marks> marks) {
		storage.addMarksDetails(marks);
	}

	public void storeStudentDetails(List<Student> studentList) {
		storage.addDetails(studentList);
	}
	
	@Override
	public void storeSem(int semNum, String semYear, List<String> rollList) {
		storage.addDetails(semNum,semYear,rollList);
		
	}
	public int  highestMarks(String s, int n) throws SQLException {
		int h = storage.highestMarks(s, n);
		return h;
	}
}
