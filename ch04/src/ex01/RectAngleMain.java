package ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RectAngleMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		Rectangle rectangle = new Rectangle(); 
		try {
			System.out.println("-----사각형의 면적 구하기-----");
			System.out.print("너비: ");
			rectangle.width = scanner.nextInt();
			System.out.print("높이: "); 
			rectangle.height = scanner.nextInt();
			
			System.out.println("면적: " + rectangle.getArea());
		
		} catch(InputMismatchException e) {
			System.out.println("너비와 높이는 정수값을 입력해주세요.");
		}
	scanner.close();
	}
}
