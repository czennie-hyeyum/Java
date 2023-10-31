package ex03;

import java.util.Scanner;

public class NestedIf {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); // System.in: 키보드

		System.out.print("점수:"); // System.out: 콘솔
		int score = scanner.nextInt();

		System.out.print("학년:");

		int year = scanner.nextInt();

		if (score >= 60) { 
			// 4학년이라면 70점 이상
			if (year == 4)
				if (score >= 70) {
					System.out.println("합격");
				} else {
					System.out.println("불합격");
				}
			
		} else {
			System.out.println("합격");
			System.out.println("불합격");
		}

		scanner.close();
	}

}
