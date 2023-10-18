package ex03;

public class DivideByZero {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 0;
		try {
			int result = calculate(num1, num2);			
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} finally {
			System.out.println("프로그램 종료");	
		}
	} //main
	
	// 예외를 던지는 경우
	public static int calculate(int n1, int n2) throws ArithmeticException {
		return n1 / n2;
	}
} //class
