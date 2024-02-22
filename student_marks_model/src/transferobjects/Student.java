package transferobjects;

public class Student {
	private String course;
	private String paper_code;
	private String paper_type;
	private String half;
	private String roll;
	private String dept;
	private int full_marks;
	private int marks_obtained;
	public Student(String course, String paper_code, String paper_type, String half, String roll, String dept,
			int full_marks, int marks_obtained) {
		super();
		this.course = course;
		this.paper_code = paper_code;
		this.paper_type = paper_type;
		this.half = half;
		this.roll = roll;
		this.dept = dept;
		this.full_marks = full_marks;
		this.marks_obtained = marks_obtained;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPaper_code() {
		return paper_code;
	}
	public void setPaper_code(String paper_code) {
		this.paper_code = paper_code;
	}
	public String getPaper_type() {
		return paper_type;
	}
	public void setPaper_type(String paper_type) {
		this.paper_type = paper_type;
	}
	public String getHalf() {
		return half;
	}
	public void setHalf(String half) {
		this.half = half;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getFull_marks() {
		return full_marks;
	}
	public void setFull_marks(int full_marks) {
		this.full_marks = full_marks;
	}
	public int getMarks_obtained() {
		return marks_obtained;
	}
	public void setMarks_obtained(int marks_obtained) {
		this.marks_obtained = marks_obtained;
	}
	
	
	
}
