package ver12;

public class PhoneInfoCompany extends PhoneInfo {
	
	private String company;
	
	public PhoneInfoCompany(String name, String phoneNumber, 
							String birthDay, String company) {
		super(name, phoneNumber, birthDay);
		this.company = company;
	}
	
	
	
	public String getCompany() {
		return company;
	}


}