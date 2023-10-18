package ex03;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		// 스캐너 생성
		Scanner scanner = new Scanner(System.in);
		
		// 숫자 출력
		System.out.print("숫자1:");
		int num1 = scanner.nextInt();
		System.out.print("숫자2:");
		int num2 = scanner.nextInt(); 
		System.out.print("연산자:"); 
		String oper = scanner.next();
	
		// 조건에 따라 결과값 출력
		switch(oper) {
		case "+":
			System.out.println("덧셈결과:" + num1 + " + " + num2 + " = " + (num1 + num2));
			break;
			
		case "-":
			System.out.println("뺄셈결과:" + num1 + " - " + num2 + " = " + (num1 + num2));
			break;
			
		case "*":	
			System.out.println("곱셈결과:" + num1 + " * " + num2 + " = " + (num1 + num2));
			break;
			
		case "/":	
			System.out.println("나눗셈결과:" + num1 + " / " + num2 + " = " + (num1 + num2));
			break;
			
		default:
			System.out.println("잘못된 결과:");
			break;
		}
		
		// 스캐너 닫기
		scanner.close();
	}

}
