package ex04;

public class Drug {
	
	private void downHeat() {
		System.out.println("열을 내립니다.");
	}
	
	private void stopRunnyNose() {
		System.out.println("콧물을 멈춥니다.");
	}
	
	private void stopCough() {
		System.out.println("기침을 멈춥니다.");
	}
	
	public void treatment() { //캡슐화
		downHeat();
		stopCough();
		stopRunnyNose();
	}
}
