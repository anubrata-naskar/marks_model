package user;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import dao.DatabaseDAO;

public class Excel {
    private List<List<String>> xlData = new ArrayList<>();
    String examDetails;
    public void readExcel(String path) throws SQLException {
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheetAt(0);
            
            Row row1 = sheet.getRow(7);
            Cell c = row1.getCell(2);
            examDetails= c.getStringCellValue();
            
            int numOfRow = getNumOfRows(sheet);
            for (int rowNum = 9; rowNum <= numOfRow; rowNum++) {
            	List<String> cols_data = new ArrayList<>();
                Row row = sheet.getRow(rowNum);
                if (row != null) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        String cellData = "";
                        switch (cell.getCellType()) {
                            case STRING:
                            	if(cell.getStringCellValue().equalsIgnoreCase("xx"))
                            		cellData = "0";
                            	else
                            		cellData = cell.getStringCellValue();
                                cols_data.add(cellData);
                                break;
                            case NUMERIC:
                                cellData = String.valueOf((int)cell.getNumericCellValue());
                                cols_data.add(cellData);
                                break;
                            case BLANK:
                            	cols_data.add("");
                            default: break;
                        }                        
                    }
                    if(!cols_data.isEmpty())
                    	xlData.add(cols_data);
                }
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
        	for (List<String> innerList : xlData) {
        		System.out.print(innerList+ "\n");
        	}
        }
        new DatabaseDAO().getExcelData(xlData,examDetails);
    }
    
    public int getNumOfRows(Sheet sheet) {
    	int rowCount = 0;
    	for (Row row : sheet) {
            boolean rowHasData = false;
            for (Cell cell : row) {
                if (cell.getCellType() != CellType.BLANK) {
                    rowHasData = true;
                    break;
                }
            }
            if (rowHasData) 
                rowCount++;
        	}
    	return rowCount;
	}
}