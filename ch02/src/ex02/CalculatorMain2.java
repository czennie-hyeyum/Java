package ex02;

public class CalculatorMain2 {

	public static void main(String[] args) {
		Calculator2 ca1 = new Calculator2();
		ca1.m = 10;
		ca1.n = 5;
		System.out.println(ca1.add());
		System.out.println(ca1.sub());
		System.out.println(ca1.mul());
		System.out.println(ca1.div());
		System.out.println(ca1.mod());

	}

}

class Calculator2 {
	//데이터
	int m;
	int n;

	
	// 기능
	
	int add () {
		return m + n;
	}
	
	int sub () {
		return m - n;
	}

	int mul () {
		return m * n;
	}
	
	int div () {
		return m / n;
	}

	int mod () {
		return m % n;
	}
}