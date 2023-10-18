package ex03;

public class Student extends Person{
	private String grade;
	private String department;
	
	public Student() {
		super();
	}

	public Student(String grade, String department) {
		super();
		this.grade = grade;
		this.department = department;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	// get 값을 갖고 온다. set 값을 설정한다.
	

}
