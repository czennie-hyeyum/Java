package ver12;

public class PhoneInfoSchool extends PhoneInfo {
	private String school;
	
	public PhoneInfoSchool(String name, String phoneNumber, 
							String birthDay, String school) {
		super(name, phoneNumber, birthDay);
		this.school = school;
	}
	
	
	public String getSchool() {
		return school;
	}


}