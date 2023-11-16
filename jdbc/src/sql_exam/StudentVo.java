package sql_exam;

public class StudentVo {
	private String sno;
	private String sname;
	private Integer syear;
	private String gender;
	private Integer major;
	private Integer score;
	
	// Setters
	public void setSno(String sno) {
		this.sno = sno;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSyear(Integer syear) {
		this.syear = syear;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMajor(Integer major) {
		this.major = major;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	// Getters
	public String getSno() {
		return sno;
	}
	public String getSname() {
		return sname;
	}
	public Integer getSyear() {
		return syear;
	}
	public String getGender() {
		return gender;
	}
	public Integer getMajor() {
		return major;
	}
	public Integer getScore() {
		return score;
	}
	
	public StudentVo(String sno, String sname, Integer syear, String gender, Integer major, Integer score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.syear = syear;
		this.gender = (gender.equals("M")) ? "M" : "F";
		this.major = major;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "StudentVo [sno=" + sno + ", sname=" + sname + ", syear=" + syear + ", gender=" + gender + ", major="
				+ major + ", score=" + score + "]";
	}
	
}
