package user;

import java.sql.SQLException;

import dao.*;

public class FetchFromDatabase {
	public static void main(String args[]) throws SQLException {
		
		
		//fetch highest marks
		//paper-code, years
		MarksDAO ma = new MarksDAO();
		int x = ma.highestMarks("cscl501",2023);
		System.out.println(x);
	}
}
