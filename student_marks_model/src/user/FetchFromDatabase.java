package user;

import java.sql.SQLException;

import dao.*;
import transferobjects.*;

public class FetchFromDatabase {
	public static void main(String args[]) throws SQLException {
		
		
		//fetch highest marks
		//paper-code, years
		MarksDAO ma = new MarksDAO();
		Marks x = ma.highestMarks("cscl501",2023);
		System.out.println(x.getObMark());
		System.out.println(x.getRoll());
	}
}
