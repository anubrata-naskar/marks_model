package dao;


import repository.*;
import transferobjects.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseDAO {
	private List<Student> studentList = new ArrayList<Student>();
	private List<Marks> marksList = new ArrayList<Marks>();
	private List<String> rollList = new ArrayList<String>();
	
	  private String url = "jdbc:mysql://localhost:3306/stu_project";
	    private String username = "root";
	    private String password = "";
	    private Connection connection = null;
	    
	    public Connection getConnection() throws SQLException {
				connection = DriverManager.getConnection(url,username,password);
	    	return connection;
	    }
	    public void getExcelData(List<List<String>> xlData,String examDetails) {
			String [] examdetails = examDetails.split("SEM");
			String dept = examdetails[0].toLowerCase();
			String [] semDetail = examdetails[1].split(" ");
			String sem = semDetail[1].toUpperCase();
			int semNum = romanToInt(sem);
			String semYear = semDetail[2].toLowerCase();
			String roll = null;
			System.out.println("dept:"+dept+"  sem:"+semNum+"  year:"+semYear);
			for(List<String> resultData :xlData) {
				roll = (resultData.get(3)+"/"+resultData.get(4)+"/"+resultData.get(5)).toLowerCase();
				String paperCode = (resultData.get(1)).toLowerCase();
				String paperTitle = (resultData.get(0)).toLowerCase();
				String examType = (resultData.get(2)).toLowerCase();
				String fullMark = resultData.get(6);
				String obMark = resultData.get(7);
				int fullMarks = Integer.parseInt(fullMark);
				int obMarks = Integer.parseInt(obMark);
				//studentList.add(new Student(roll,dept));
				studentList.add(new Student(paperTitle, paperCode, examType, " ", roll, dept,fullMarks, obMarks));
				rollList.add(roll);
				marksList.add(new Marks(paperCode,semYear,fullMark,obMark,paperTitle,examType,roll));
			}
			BaseRepository marksRepo = new MarksRepository(new MySQLRepository());
			marksRepo.storeSem(semNum,semYear,rollList);
			marksRepo.storeDetails(marksList);
			marksRepo.storeStudentDetails(studentList);
		}
		
		  public static int romanToInt(String s)  
		   {  
		        Map<Character, Integer> map=new HashMap<Character, Integer>();  
		        //adding elements to the Map   
		        map.put('I',1);  
		        map.put('V',5);  
		        map.put('X',10);  
		        map.put('L',50);  
		        map.put('C',100);  
		        map.put('D',500);  
		        map.put('M',1000);    
		        s = s.replace("IV","IIII");  
		        s = s.replace("IX","VIIII");  
		        s = s.replace("XL","XXXX");  
		        s = s.replace("XC","LXXXX");  
		        s = s.replace("CD","CCCC");  
		        s = s.replace("CM","DCCCC");  
		        int number = 0;  
		    //loop iterates over the roman numeral   
		        for (int i = 0; i < s.length(); i++)  
		        {  
		    //getting each character of roman numeral and adding it to the variable number  
		            number = number + (map.get(s.charAt(i)));  
		        }
		        return number;
		   }
}
