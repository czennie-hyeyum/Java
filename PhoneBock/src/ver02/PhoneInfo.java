package ver02;

public class PhoneInfo {
	public String name;
	public String phonNumber;
	public String birthDay;
	
	public PhoneInfo(String name, String phonNumber) {
		this.name = name;
		this.phonNumber = phonNumber;
	}
	
	public PhoneInfo(String name, String phonNumber, String birthDay) {
		this(name, phonNumber);
		/* 
			this.name = name;
			this.phonNumber = phonNumber; 
		*/
		this.birthDay = birthDay; 
	}
	
	public void showInfo() {
		System.out.println("이름: " + this.name);
		System.out.println("전번: " + this.phonNumber);
		if (this.birthDay != null) {
		System.out.println("생일: " + this.birthDay);
		}
		System.out.println("------------------");
	}

}
