package ex01;

interface MyFunction {
	int calc(int x, int y);
}

public class LambdaEx1 {

	public static void main(String[] args) {
		
		// 매개변수 x, y의 합과 차를 출력하는 2개의 람다식
		// 람다식
		MyFunction add = (x, y) -> {
			return x + y;
		}; 
		
		// 람다식. {}와 return 생략
		MyFunction minus = (x, y) -> x - y;
		
		// 합 구하기
		int result1 = add.calc(1, 2);
		System.out.println("result1: " + result1);
		
		// 차 구하기
		int result2 = minus.calc(1, 2);
		System.out.println("result2: " + result2);
		
	}

}
