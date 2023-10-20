package ex05;

public class PhoneMain {

	public static void main(String[] args) {
		// PhoneInterface p1 = new PhoneInterface();
		// -> Interface는 객체 생성 불가
		
		SmartPhone phone1 = new SmartPhone();
		phone1.sendCall();
		phone1.receiverCall();
		
		// 인터페이스를 상위 타입으로 사용 가능
		PhoneInterface phone2 = new SmartPhone();
		phone2.printLogo();
		phone2.sendCall();
		phone2.receiverCall();
	}

}
