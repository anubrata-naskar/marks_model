package user;
import dao.MarksDAO;
import transferobjects.Student;

import java.util.ArrayList;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Iterator;

public class Upload_details {
	   // Creating an ArrayList of Strings
	public static void main(String args[]) throws SQLException {
		
	
//    ArrayList<String> stringList = new ArrayList<>();
//    // Adding elements to the ArrayList
//    void addElement() {
//    stringList.add("1");
//    stringList.add("2");
//    stringList.add("3");
//    stringList.add("4");
//    stringList.add("5");
//    }
//    void uploadMarks() {
//    MarksDAO ma = new MarksDAO();
//    ma.uploadDetails(stringList);
//    }
//    
		MarksDAO mrd = new MarksDAO();
		Student stu = mrd.get("aaa");
		String coll = stu.getColl();
		String cate = stu.getCate();
		int num = stu.getNumber();
		int marks = stu.getMarks_obtained();
		System.out.println("Coll - "+coll);
		System.out.println("Cate - "+cate);
		System.out.println("Num - "+num);
		System.out.println("Makrs - "+marks);
}
		
		

//    public static void main(String[] args) {
//        try {
//            FileInputStream file = new FileInputStream(new File("C:\\Users\\Administrator\\Downloads\\CSCL501.xlsx"));
//
//            Workbook workbook = new XSSFWorkbook(file);
//            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//
//            Iterator<Row> rowIterator = sheet.iterator();
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                // Start reading from the 10th row
//                if (row.getRowNum() >= 9) {
//                    Iterator<Cell> cellIterator = row.cellIterator();
//
//                    // Assuming data is in columns B to J
//                    while (cellIterator.hasNext()) {
//                        Cell cell = cellIterator.next();
//                        // Check for blank row
//                        if (cell.getCellType() == CellType.BLANK) {
//                            break; // Break if a blank cell is found
//                        }
//                        // Assuming data is numeric; modify as needed based on your data types
//                        System.out.print(cell.getNumericCellValue() + "\t");
//                    }
//                    System.out.println(); // Move to the next line for the next row
//                }
//            }
//            workbook.close();
//            file.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
