package ex01;

public class TestThread {

	public static void main(String[] args) {
		TimerThread th = new TimerThread();
		// th.run();
		th.start();
		
		int count = 1000;
		while (count <= 100000) {
			try {
				Thread.sleep(100); // 예외를 던짐
				System.out.println(++count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("main 종료");
	}

}

// 별도 클래스
class TimerThread extends Thread {
	// 스레드의 메인
	@Override
	public void run() {
		// delay(millis)
		int counter = 0;
		while (counter <= 100) {
			try {
				Thread.sleep(100); // 예외를 던짐
				System.out.println(++counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("run 종료");
	}
	
}