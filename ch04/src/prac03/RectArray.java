package prac03;

import java.util.Scanner;

public class RectArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Rect[] rects = new Rect[4];
		
		for (int i = 0; i < rects.length; i++) {
			System.out.print((i + 1) + " 너비와 높이 >>");
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			rects[i] = new Rect(width, height);
		}
		
		System.out.println("저장하였습니다...");
		int sum = 0;
		for (Rect rect : rects) {
			int area = rect.getArea();
			sum += area;
		}
		
		System.out.println("사각형의 전체 합은 " + sum);
		
		scanner.close();
	}

}
