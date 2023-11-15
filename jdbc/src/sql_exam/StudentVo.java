package sql_exam;

public class StudentVo {
	private Character sno;
	private String sname;
	private Integer syear;
	private String gender;
	private Integer major;
	private Integer score;
	
	public Character getSno() {
		return sno;
	}
	public void setSno(Character sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSyear() {
		return syear;
	}
	public void setSyear(Integer syear) {
		this.syear = syear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getMajor() {
		return major;
	}
	public void setMajor(Integer major) {
		this.major = major;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "StudentVo [sno=" + sno + ", sname=" + sname + ", syear=" + syear + ", gender=" + gender + ", major="
				+ major + ", score=" + score + "]";
	}
	public StudentVo(Character sno, String sname, Integer syear, String gender, Integer major, Integer score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.syear = syear;
		this.gender = gender;
		this.major = major;
		this.score = score;
	}
	
}
