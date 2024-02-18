package dao;

//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//import org.apache.poi.ss.usermodel.*;

public class Excel {
//    private List<List<String>> rows_data = new ArrayList<>();
//
//    public static void main(String args[]) {
//        Excel obj = new Excel();
//        obj.readExcel(10);
//    }
//
//    public void readExcel(int start_row) {
//        try {
//            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\BTECH 5TH SEMESTER 2023 CSCP506 100.xlsx");
//            Workbook wb = WorkbookFactory.create(fis);
//            Sheet sheet = wb.getSheetAt(0);
//
//            for (int rowNum = start_row - 1; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) {
//                Row row = sheet.getRow(rowNum);
//                if (row != null) {
//                    Iterator<Cell> cellIterator = row.cellIterator();
//                    List<String> cols_data = new ArrayList<>();
//
//                    while (cellIterator.hasNext()) {
//                        Cell cell = cellIterator.next();
//                        String cellData = "";
//
//                        switch (cell.getCellType()) {
//                            case STRING:
//                                cellData = cell.getStringCellValue();
//                                break;
//                            case NUMERIC:
//                                cellData = String.valueOf(cell.getNumericCellValue());
//                                break;
//                            default: System.out.print("");
//                        }
//                        if (cellData != null && !cellData.isEmpty()) {
//                            cols_data.add(cellData);
//                        }
//                    }
//                    if (!cols_data.isEmpty()) {
//                        rows_data.add(cols_data);
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            for (List<String> innerList : rows_data) {
//                for (String data : innerList) {
//                    System.out.print(data + "\t");
//                }
//                System.out.println();
//            }
//        }
//    }
}