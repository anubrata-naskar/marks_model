package transferobjects;

public class Marks {
	private String paperCode,semYear,fullMark,obMark,paperTitle,examType,roll;
	
	public Marks(String paperCode,String semYear,String fullMark,String obMark, String paperTitle, String examType, String roll) {
		this.paperCode = paperCode;
		this.semYear = semYear;
		this.fullMark = fullMark;
		this.obMark = obMark;
		this.paperTitle = paperTitle;
		this.examType = examType;
		this.roll = roll;
	}
	public String getPaperCode() {
		return paperCode;
	}
	
	public String getSemYear() {
		return semYear;
	}
	
	public String getFullMark() {
		return fullMark;
	}
	
	public String getObMark() {
		return obMark;
	}
	
	public String getPaperTitle() {
		return paperTitle;
	}
	
	public String getExamType() {
		return examType;
	}
	
	public String getRoll() {
		return roll;
	}
}
