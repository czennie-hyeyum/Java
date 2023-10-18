package ex03;

import java.util.Scanner;

public class Prace08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("커피 주문하세요>>");
		String coffee = scanner.next();
		int count = scanner.nextInt();
		
		switch(coffee) {
		case "에스프레소":
			System.out.println((2000 * count) + "원입니다.");
			break;
			
		
		}
		
		
		
		
		scanner.close();
		
	}

}
