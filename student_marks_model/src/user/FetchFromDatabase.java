package user;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import dao.*;
import transferobjects.*;
public class FetchFromDatabase {
	MarksDAO ma = new MarksDAO();
	public Marks getAvgMarks(String paperCode, String year) {
		Marks avgMarks=null;
		try {
			avgMarks = ma.avgMarks(paperCode,Integer.parseInt(year));
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return  avgMarks;
	}
	
	public Marks getHighMarks(String paperCode, String year) {
		Marks fullMarks=null;
		try {
			fullMarks = ma.highestMarks(paperCode,Integer.parseInt(year));
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return  fullMarks;
	}
	
	public List<Marks> generatePDF(String roll, String year, String sem) {
		Marks l = null;
		try {
			l = ma.marks_sheet_gen(roll,year,sem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Marks> x = l.getMarksList();
		PDDocument document = new PDDocument();
		String pdfName = roll.replace('/','_');
		String pdfFilePath = "C:\\Users\\anubrata\\Downloads\\marksheet-"+pdfName+".pdf";
		
		PDPage page = new PDPage();
        document.addPage(page);
        String text = "MARKSHEET : "+roll;
        String text2 = "Paper code    Full Marks  Marks Obtained      Paper Title";
        
        
		//PDPageContentStream contentStream;
        try {
        	PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setNonStrokingColor(Color.DARK_GRAY);
            contentStream.addRect(30, 60, 550, 700);
            contentStream.stroke();
            contentStream.setLeading(14.5f);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
            contentStream.newLineAtOffset(100, 700); // Adjust coordinates as needed
            contentStream.showText(text);
            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.newLine();
            contentStream.newLine();
            contentStream.newLine();
            contentStream.newLine();
            contentStream.setFont(PDType1Font.COURIER_BOLD, 12);
            contentStream.showText(text2);
            contentStream.newLine();
            contentStream.newLine();
            contentStream.newLine();
	  
            for (Marks details : x) {
//			System.out.println("Paper code: " + details.getPaperCode() + ", Paper Title: " + details.getPaperTitle() +
//                    ", Full Marks: " + details.getFullMark() + ", Marks Obtained: " + details.getObMark());
		String text1 =  details.getPaperCode()+"       "+ details.getFullMark()+"  "+details.getObMark()+" "+details.getPaperTitle();
		//String text3 = "Full Marks: " + details.getFullMark();
		//String text4 = "Marks Obtained: " + details.getObMark();
		
            
            contentStream.newLine();
            contentStream.showText(text1);
            contentStream.newLine();
//            contentStream.showText(text3);
//            contentStream.newLine();
//            contentStream.showText(text4);
//            contentStream.newLine();
        }
		 System.out.println("PDF created successfully.");
		contentStream.endText();
        contentStream.close();
		
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   try {
			document.save(new File(pdfFilePath));
			document.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return x;
	}
//	public static void main(String args[]) throws SQLException {
		
		
		//fetch highest marks
		//paper-code, years
//		MarksDAO ma = new MarksDAO();
//		Marks x = ma.highestMarks("CSMC101",2023);
//		Marks y = ma.avgMarks("CSMC101",2023);
//		Marks z = ma.qualify_perc("CSMC101",2023);
//		System.out.println("highest marks - "+x.getObMark()+"   roll - "+x.getRoll());
//		System.out.println("avg marks - "+y.getObMark());
//		System.out.println("percentage of qualified - "+z.getObMark());
		
		//generate marks-sheet for M91	MSC	214039
		/**MarksDAO ma = new MarksDAO();
		Marks l = ma.marks_sheet_gen("m91/msc/214032");
		List<Marks> x = l.getMarksList();
		for (Marks details : x) {
            System.out.println("Paper code: " + details.getPaperCode() + ", Paper Title: " + details.getPaperTitle() +
                               ", Full Marks: " + details.getFullMark() + ", Marks Obtained: " + details.getObMark());
        }**/
		
//	}

	public List<Marks> getAbsentStudents(String paperCode, String year) {
		Marks l = null;
			try {
				l = ma.getAbsentStudent(paperCode, year);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		List<Marks> x = l.getMarksList();
		return x;
	}

	public List<Marks> getFailedStudents(String subCode, String examType, String year, String passPerc) {
		Marks l = null;
		try {
			int x =Integer.parseInt(passPerc);
			l = ma.getFailedStudents(subCode, examType, year, x  );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Marks> x = l.getMarksList();
		for (Marks details : x) {
            System.out.println("Paper code: " + details.getPaperCode() + ", Paper Title: " + details.getPaperTitle() +
                               ", Full Marks: " + details.getFullMark() + ", Marks Obtained: " + details.getObMark()+ ", Rol: " + details.getRoll());
        }
		return x;
	}
	
}
