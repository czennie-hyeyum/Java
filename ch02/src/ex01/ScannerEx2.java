package ex01;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		System.out.print("숫자1: ");
		Scanner scan = new Scanner(System.in);
		
		// 숫자2 출력
		int num1 = scan.nextInt();
		System.out.print("숫자2: ");
		
		// 결과값 출력
		int num2 = scan.nextInt(); 
		System.out.print("결과: " + num1 + " + " + num2 + " = " + (num1 + num2));
		
		// 스캐너 닫기 및 종료 출력
		scan.close();
		System.out.println("---종료---");
	}

}