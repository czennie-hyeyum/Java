package testone;

import java.util.Scanner;

public class ExamCalculator {

	public static void main(String[] args) {
		System.out.println("*** 간단 계산기 ***");
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자1: ");
		int num1 = scan.nextInt();
		System.out.print("숫자2: ");
		int num2 = scan.nextInt();
		
		System.out.println("덧셈: "+ num1 + "+"+ num2 + "=" + add(num1, num2));
		System.out.println("뺄셈: "+ num1 + "-"+ num2 + "=" + sub(num1, num2));
		System.out.println("곱셈: "+ num1 + "*"+ num2 + "=" + mul(num1, num2));
		System.out.println("나눗셈: "+ num1 + "/"+ num2 + "=" + div(num1, num2));
		System.out.println("나머지: "+ num1 + "%" + num2 + "=" + mod(num1, num2));
		
		scan.close();
	}
	
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
		return x / y;
	}
	public static int mod(int x, int y) {
		return x % y;
	}
	
	

}
