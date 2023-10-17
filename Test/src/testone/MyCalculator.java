package testone;

public class MyCalculator {  //main이 아닌 일반 class임

	// 데이터(변수-멤버필드)
	int x;
	int y;
	
	// 기능(함수-멤버메서드)
	
	// 덧셈
	int add() {
		return x + y;
	}
	
	// 뺄셈
	int sub() {
		return x - y;
	}
	// 곱셈
	int mul() {
		return x * y;
	}
	// 나눗셈
	int div() {
		return x / y;
	}
	// 나머지
	int mod() {
		return x % y;
	}
}
