package ex05;

public class SmartPhone implements PhoneInterface {

	@Override
	public void sendCall() {
		System.out.println("전화를 겁니다.");
	}

	@Override
	public void receiverCall() {
		System.out.println("전화를 받습니다.");
	}

}
