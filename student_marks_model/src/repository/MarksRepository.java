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
	public void storeDetails(List<Marks> marks) throws SQLException{
		storage.addMarksDetails(marks);
	}

	public void storeStudentDetails(List<Student> studentList) throws SQLException{
		storage.addDetails(studentList);
	}
	
	@Override
	public void storeSem(int semNum, String semYear, List<String> rollList) throws SQLException {
		storage.addDetails(semNum,semYear,rollList);
	}
	
	public Marks  highestMarks(String s, int n) throws SQLException {
		Marks h = storage.highestMarks(s, n);
		return h;
	}
	public Marks  avgMarks(String paper_code, int year) throws SQLException {
		Marks h = storage.avgMarks(paper_code, year);
		return h;
	}
	public Marks  qualify_perc(String paper_code, int year) throws SQLException {
		Marks h = storage.qualify_perc(paper_code, year);
		return h;
	}
	//marks-sheet generate
	public Marks marks_sheet_gen(String roll) throws SQLException {
		Marks h = storage.marks_sheet_gen(roll);
		return h;
	}
}
