package ex01;

import java.util.Scanner;

public class ArithmeticOperator {

	public static void main(String[] args) {
		//
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자입력: ");
		int num = scan.nextInt();

		if (num % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");

		}

		/*숫자입력:
		3의 배수이거나 5의 배수라면
		Pass
		그렇지 않으면
		Fail
		*/
		
		System.out.print("숫자입력: ");
		int num1 = scan.nextInt();

		if (num1 % 3 == 0 || num1 % 5 == 0) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		scan.close();
	}

}
