package ex03;

import java.util.Scanner;

public class NestedIf {

	public static void main(String[] args) {

		// 스캐너 생성
		// Scanner: 데이터 타입, scanner: 참조변수 (타입이 아닌 변수에 접근)
		// 뒤에 먼저 작성하고 앞을 작성해도 됨
		Scanner scanner = new Scanner(System.in); // System.in: 키보드

		// 점수: 출력
		System.out.print("점수:"); // System.out: 콘솔
		// 사용자로부터 점수 입력(nextInt) 받기
		int score = scanner.nextInt();

		// 학년: 출력
		System.out.print("학년:");

		// 사용자로부터 학년 입력 받기
		int year = scanner.nextInt();

		// 조건에 따라 합격, 불합격 출력(범위 조건 if)
		// 중첩 가능
		if (score >= 60) { 
			// 4학년이라면 70점 이상
			// if (year == 4 && score >= 70) 이렇게 표현해도 됨
			if (year == 4)
				if (score >= 70) {
					System.out.println("합격");
				} else {
					System.out.println("불합격");
				}
			
		} else {
			// 합격 출력
			System.out.println("합격");
			// 불합격 출력
			System.out.println("불합격");
		}

		// 스캐너 닫기
		scanner.close();
	}

}
