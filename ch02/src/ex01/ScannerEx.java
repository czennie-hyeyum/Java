package ex01;

import java.util.Scanner; // 임포트 지정 시 스캐너 위치 작성을 안 해주어도 됨

public class ScannerEx {
	// ex01, ScannerEx 이름 성 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 작업들 (사용자로부터 키보드 입력을 받아서 뭔가를 한다.)
		String str = scan.next();
		System.out.println("str:" + str);

		int num = scan.nextInt();
		System.out.println("num:" + num);

		double d = scan.nextDouble();
		System.out.println("d:" + d);

		String data = scan.nextLine(); // 엔터키 전까지
		System.out.println("data:" + data);

		// 스캐너 닫기
		scan.close(); 
		System.out.println("---프로그램 종료---");
	}

}
