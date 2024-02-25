package user;

import java.sql.SQLException;

import dao.*;
import transferobjects.*;

public class FetchFromDatabase {
	public static void main(String args[]) throws SQLException {
		
		
		//fetch highest marks
		//paper-code, years
		MarksDAO ma = new MarksDAO();
		Marks x = ma.highestMarks("cscp506",2023);
		Marks y = ma.avgMarks("cscp506",2023);
		Marks z = ma.qualify_perc("cscp506",2023);
		System.out.println("highest marks - "+x.getObMark()+"   roll - "+x.getRoll());
		System.out.println("avg marks - "+y.getObMark());
		System.out.println("percentage of qualified - "+z.getObMark());
	}
}
