package user;

import java.sql.SQLException;
import java.util.List;

import dao.*;
import transferobjects.*;

public class FetchFromDatabase {
	public static void main(String args[]) throws SQLException {
		
		
		//fetch highest marks
		//paper-code, years
		/**MarksDAO ma = new MarksDAO();
		Marks x = ma.highestMarks("CSMC101",2023);
		Marks y = ma.avgMarks("CSMC101",2023);
		Marks z = ma.qualify_perc("CSMC101",2023);
		System.out.println("highest marks - "+x.getObMark()+"   roll - "+x.getRoll());
		System.out.println("avg marks - "+y.getObMark());
		System.out.println("percentage of qualified - "+z.getObMark());**/
		
		//generate marks-sheet for M91	MSC	214039
		MarksDAO ma = new MarksDAO();
		Marks l = ma.marks_sheet_gen("m91/msc/214032");
		List<Marks> x = l.getMarksList();
		for (Marks details : x) {
            System.out.println("Paper code: " + details.getPaperCode() + ", Paper Title: " + details.getPaperTitle() +
                               ", Full Marks: " + details.getFullMark() + ", Marks Obtained: " + details.getObMark());
        }
	}
}
