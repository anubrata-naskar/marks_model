package user;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Upload_details {
	
	   // Creating an ArrayList of Strings
//	 public static void main(String args[]) throws SQLException {
//		
//	
////    ArrayList<String> stringList = new ArrayList<>();
////    // Adding elements to the ArrayList
////    void addElement() {
////    stringList.add("1");
////    stringList.add("2");
////    stringList.add("3");
////    stringList.add("4");
////    stringList.add("5");
////    }
////    void uploadMarks() {
////    MarksDAO ma = new MarksDAO();
////    ma.uploadDetails(stringList);
////    }
////    
//		MarksDAO mrd = new MarksDAO();
//		Student stu = mrd.get("aaa");
//		String coll = stu.getColl();
//		String cate = stu.getCate();
//		int num = stu.getNumber();
//		int marks = stu.getMarks_obtained();
//		System.out.println("Coll - "+coll);
//		System.out.println("Cate - "+cate);
//		System.out.println("Num - "+num);
//		System.out.println("Makrs - "+marks);
//} 
	
	
	//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
	//upload-detailsgg
	public static void main(String[] args) throws SQLException  {
    	String path = "C:\\Users\\anubrata\\Downloads\\student database project\\M.SC. 1ST SEMESTER 2023 CSMC110.xlsx";
    	int noOfStudent = 51;
    	new Excel().readExcel(path,noOfStudent);
    }
	//upload-details
	
	
}