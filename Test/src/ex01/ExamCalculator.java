package ex01;

import java.util.Scanner;

public class ExamCalculator {

	public static void main(String[] args) { // 함수 진행 시 public static로 시작
			Scanner scanner = new Scanner(System.in); 
			System.out.print("***간단 계산기***");
			
			System.out.print("숫자1: ");
			int num1 = scanner.nextInt();
			
			System.out.print("숫자2: ");
			int num2 = scanner.nextInt();
			
			System.out.println("덧셈: " + num1 + "+" + num2 + "=" + add(num1, num2));
			System.out.println("빼기: " + num1 + "-" + num2 + "=" + add(num1, num2));
			System.out.println("곱하기: " + num1 + "*" + num2 + "=" + add(num1, num2));
			System.out.println("나누기: " + num1 + "/" + num2 + "=" + add(num1, num2));
			System.out.println("나머지: " + num1 + "|" + num2 + "=" + add(num1, num2));
			
			scanner.close();
			
	} // main
	
	public static int add(int x, int y) {
		return x + y;
	} 
	
	public static int sub(int x, int y) {
		return x - y;
	} 
	
	public static int mul(int x, int y) {
		return x * y; 	
	}
	
	public static int div(int x, int y) {
		return x % y; 
	}
	
	public static int mod(int x, int y) {
		return x | y; 
	}
	
} // class
