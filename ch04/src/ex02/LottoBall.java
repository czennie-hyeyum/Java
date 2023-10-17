package ex02;

public class LottoBall {
	public int number;
	public String color;
	
	public LottoBall() {}
	
	public LottoBall(int number, String color) {
		this.number = number;
		this.color = color;
	}
	
	public void showInfo() {
		String strNumber = String.valueOf(number); // 숫자 데이터를 글자 데이터로 변환
		if(this.number < 10) {
			strNumber = "0" + strNumber;
		}
		System.out.println("{" + strNumber + ", " + this.color + "}");
	}
}
