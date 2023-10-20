package ex05;

public interface PhoneInterface {
	public static final int TIMEOUT = 10000;
	// 추상 메서드
	public void sendCall();
	public void receiveCall();
	default void printLogo() {
		System.out.println("*** Phone ***");
	}
}
