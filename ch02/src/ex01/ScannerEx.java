package ex01;

import java.util.Scanner;

public class ScannerEx {
	// ex01, ScannerEx 이름 성 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("글자를 입력하세요: ");
		String str = scan.next();
		System.out.println("str: " + str);

		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();
		System.out.println("num: " + num);

		System.out.print("실수를 입력하세요: ");
		double d = scan.nextDouble();
		System.out.println("d:" + d);
		
		System.out.print("글자를 입력하세요: ");
		String data = scan.nextLine();
		System.out.println("data:" + data);
		
		scan.close(); 
		System.out.println("---프로그램 종료---");
	}

}
