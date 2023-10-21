package ex02;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator ca1 = new Calculator();
		int i = 10;
		int j = 5;
		
		System.out.println(ca1.add(i, j));
		System.out.println(ca1.sub(i, j));
		System.out.println(ca1.mul(i, j));
		System.out.println(ca1.div(i, j));
		System.out.println(ca1.mod(i, j));
	}

}

class Calculator {
	int add (int m, int n) {
		return m + n;
	}
	
	int sub (int m, int n) {
		return m - n;
	}

	int mul (int m, int n) {
		return m * n;
	}
	
	int div (int m, int n) {
		return m / n;
	}

	int mod (int m, int n) {
		return m % n;
	}
}