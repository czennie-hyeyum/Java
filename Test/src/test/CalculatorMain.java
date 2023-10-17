package test;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		MyCalculator calculator = new MyCalculator();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*** 간단 계산기 ***");
		System.out.print("숫자1: ");
		calculator.x = scanner.nextInt();
		System.out.print("숫자2: ");
		calculator.y = scanner.nextInt();
		
		System.out.println("덧셈: " + calculator.x + " + " + calculator.y + " = " + calculator.add());
		System.out.println("뺄셈: " + calculator.x + " - " + calculator.y + " = " + calculator.sub());
		System.out.println("곱셈: " + calculator.x + " * " + calculator.y + " = " + calculator.mul());
		System.out.println("나눗셈: " + calculator.x + " / " + calculator.y + " = " + calculator.div());
		System.out.println("나머지: " + calculator.x + " % " + calculator.y + " = " + calculator.mod());
		
		scanner.close();
	}

}
