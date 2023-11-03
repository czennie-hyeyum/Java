package ver03;

public class PhoneInfo {
	public String name;
	public String phoneNumber;
	public String birthDay;
	
	// public PhoneInfo() { }
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public PhoneInfo(String name, String phoneNumber, String birthDay) {
		/*
		this.name = name;
		this.phoneNumber = phoneNumber;
		*/
		this(name, phoneNumber);
		this.birthDay = birthDay;
	}
	public void showInfo() {
		System.out.println("이름:" + this.name);
		System.out.println("전번:" + this.phoneNumber);
		if (this.birthDay != null) {
			System.out.println("생일:" + this.birthDay);
		}
		System.out.println("-------------------------");
		
	}
}