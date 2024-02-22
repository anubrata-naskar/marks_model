package user;

import java.io.FileInputStream;
import java.util.Iterator;

//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.Excel;

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
		
		

//    public static void main(String[] args) {
//    	String path = "C:\\Users\\Administrator\\Downloads\\BTECH 5TH SEMESTER 2023 CSCP506 100.xlsx";
//    	int noOfStudent = 51;
//    	new Excel().readExcel(path,noOfStudent);
//        try {
//            FileInputStream file = new FileInputStream(new File("C:\\Users\\\\Administrator\\Downloads\\BTECH 5TH SEMESTER 2023 CSCP506 100.xlsx"));
//
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//
//            Iterator<Row> rowIterator = sheet.iterator();
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                // Start reading from the 10th row
//                if (row.getRowNum() >= 9 ) {
//                    Iterator<Cell> cellIterator = row.cellIterator();
//
//                    // Assuming data is in columns B to J
//                    while (cellIterator.hasNext()) {
//                        Cell cell = cellIterator.next();
//                        if(cell.getColumnIndex() == 7)
//                        	System.out.print((int)cell.getNumericCellValue() + "\t"); 
//                        else
//                        	System.out.print(cell.getStringCellValue() + "\t");
//                        // Check for blank row
////                        if (cell.getCellType() == CellType.BLANK) {
////                            break; // Break if a blank cell is found
////                        }
//                        // Assuming data is numeric; modify as needed based on your data types
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