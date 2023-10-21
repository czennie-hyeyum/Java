package ex03;

import java.util.Scanner;

public class Prac10 {

	public static void main(String[] args) {
		// p.89 Prac10 실습 문제 Prac8 변형 문제
		// if-else 활용

		Scanner scanner = new Scanner(System.in);

		System.out.print("커피 주문하세요>>");
		String coffee = scanner.next();
		int count = scanner.nextInt();

		//에스프레소 2000, 아메리카노 2500, 카푸치노 3000, 카페라떼 3500

		switch (coffee) {
		case "에스프레소":
			// 카운트가 10잔 이상
			if (count >= 10) {
				System.out.println((int) (2000 * count * (1 - 0.05)) + "원입니다.");		
			} else {
				System.out.println((2000 * count) + "원입니다.");
				break;
			} // 에스프레소

		case "아메리카노":
			System.out.println((2500 * count) + "원입니다.");
			break;
		case "카푸치노":
			System.out.println((3000 * count) + "원입니다.");
			break;
		case "카페라떼":
			System.out.println((3500 * count) + "원입니다.");
			break;
		} // switch

		scanner.close();

	}

} 
