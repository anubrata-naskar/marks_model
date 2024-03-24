package user;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import dao.DatabaseDAO;

public class Excel {
    private List<List<String>> xlData = new ArrayList<>();
    String examDetails;
//    public static void main(String args[]) {
//        Excel obj = new Excel();
//        obj.readExcel(10);
//    }
//
    public void readExcel(String path,int noOfStudent) throws SQLException {
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);

            Row row1 = sheet.getRow(7);
            Cell c = row1.getCell(2);
            examDetails= c.getStringCellValue();
            
            for (int rowNum = 9; rowNum < noOfStudent; rowNum++) {
            	List<String> cols_data = new ArrayList<>();
                Row row = sheet.getRow(rowNum);
                if (row != null) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellData = "";
                        switch (cell.getCellType()) {
                            case STRING:
                                cellData = cell.getStringCellValue();
                                cols_data.add(cellData);
                                break;
                            case NUMERIC:
                                cellData = String.valueOf((int)cell.getNumericCellValue());
                                cols_data.add(cellData);
                                break;
                            default: break;
                        }                        
                    }
                    xlData.add(cols_data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	for (List<String> innerList : xlData) {
        		System.out.print(innerList+ "\n");
        	}
        }
        new DatabaseDAO().getExcelData(xlData,examDetails);
        
    }
    
}