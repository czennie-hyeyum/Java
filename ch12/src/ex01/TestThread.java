package ex01;

public class TestThread {
	public static void main(String[] args) {
		
		TimerThread th = new TimerThread();
		th.start();
		
		int count = 1000;
		while (count <= 100000) {
			try {
				Thread.sleep(100); 
				System.out.println(++count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("main 종료");
	}

}

class TimerThread extends Thread {
	@Override
	public void run() {
		int counter = 0;
		while (counter <= 100) {
			try {
				Thread.sleep(100); 
				System.out.println(++counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("run 종료");
	}
	
}