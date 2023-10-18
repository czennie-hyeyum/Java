package ex02;

import java.util.Scanner;

public class GuessNumT {
	
	public static final Scanner scanner = new Scanner(System.in);
	public static int[] records = new int[5];
	public static int count = 5;
	public static int targetNum = 0;
	
	// 메인 클래스
	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
//		int[] records = {30000, 30000, 30000, 30000, 30000};
		// int[] records = new int[5]; // {0, 0, 0, 0, 0}
		// int count = 5;
		initRecords(); // 초기화
		// showRecords(records);
		targetNum = makeTargetNum(); //
		System.out.println("targetNum:" + targetNum);
		showRule();
		runGame();
		
		// 기회 소진 출력
		System.out.println("기회를 모두 소진하였습니다.");
		
		// 스캐너 닫기
		scanner.close();
	} // main
	
	// 게임 시작
	public static void runGame() {
		while(true) {
			System.out.println("for"); // for 출력
			int userNum = inputData(); 
			judge(targetNum, userNum);
			count--; 
			if (count == 0) { // 기회가 0번이 되었을 때 멈춤
				break; 
			}
			System.out.println("남은 기회는 " + count + "번입니다."); // 남은 기회 출력
		}
	}
	
	public static int makeTargetNum() { // 원하는 숫자 클래스
		int targetNum = (int)(Math.random() * 100) + 1; // 100개의 정수 중 하나를 랜덤 선정
		return targetNum;
	}
	
	public static void judge(int targetNum, int userNum) { //
		if (targetNum == userNum) { // 랜덤 숫자와 유저 숫자가 같을 때 True
			System.out.println("정답");
		} else if (targetNum > userNum) { // 유저 숫자보다 랜덤 숫자가 클 때
			System.out.println(userNum + "보다 큽니다.");
		} else { // 유저 숫자보다 랜덤 숫자가 작을 때
			System.out.println(userNum + "보다 작습니다."); 
		}
	}
	
	public static int inputData() {
		System.out.print("입력:"); // 입력 출력
		int num = scanner.nextInt(); // 
		return num;
	}
	
	// 시작 메시지(게임 규칙) 출력하기
	public static void showRule() {
		System.out.println("===== 1 ~ 100 사이의 임의의 수를 맞춰 보세요 =====");
		System.out.println("----- 기회는 5번 입니다. -----");
	}
	
	/**
	 * 기록을 30000으로 초기화하기
	 * @param records 점수 기록 배열
	 */
	
	// 기록 초기화하기
	public static void initRecords() {
		for (int i = 0; i < records.length; i++) {
			records[i] = 30000; // 
		}
	}
	
	// 기록 보여주기
	public static void showRecords(int[] records) {
		for (int aRecord : records) { // 읽기
			System.out.print(aRecord + " ");
		}
	}
		
}