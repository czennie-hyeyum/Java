package ex02;

import java.util.Scanner;

public class GuessNum {

	public static void main(String[] args) {
		// 1 ~ 100 사이의 임의의 수를 빨리 맞추기
		
		//기록 1위 ~ 5위
		
		System.out.println("기록: 1위 ~ 5위");

		// 스캐너 생성
		Scanner scanner = new Scanner(System.in);
		
		// 100의 정수 값 중 랜덤의 정수 숫자 하나 랜덤
		int rand = (int)(Math.random() * 100) + 1;
			System.out.println(rand);
		
		// 헤더 출력
		System.out.println("====== 1 ~ 100 사이의 임의의 수를 맞춰 보세요 ======");
		System.out.println("------ 기회는 총 5번입니다. ------");
		
		// 타이머
		long starttime = System.currentTimeMillis();
		
		// 숫자 입력
		System.out.print("입력: ");
		int user = scanner.nextInt();
		
		// 숫자 출력
		
		
		// 남은 횟수 카운트
		
		
		// 남은 기회는 n번입니다. / 정답입니다.
		
		if (user == rand) {
		System.out.println("정답입니다.");
		} else if(user > rand) {
			System.out.println("남은 기회는" + "번입니다");
		} else {
			System.out.println("기회를 모두 소진하였습니다.");
		}
		
		
		//현재 기록
		
		//게임 재시작
		
			
		// 스캐너 닫기
		scanner.close();
		
	} //main

} //class
