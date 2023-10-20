package ex05;

public class SmartPhone implements PhoneInterface, CalcInterface {

	@Override
	public void sendCall() {
		System.out.println("전화를 겁니다.");
	}

	@Override
	public void receiverCall() {
		System.out.println("전화를 받습니다.");
	}

	@Override
	public void calulate() {
		System.out.println("계산을 합니다.");
	}

}
