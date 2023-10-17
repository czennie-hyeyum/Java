package ex02;

import java.util.Scanner;

public class ArrayAccess2 {

	public static void main(String[] args) {
		// 입력 받은 수를 스와핑
		
		// 스캐너 생성
		Scanner scanner = new Scanner(System.in);
		System.out.println("---버블 정렬---");
		
		// 정수 저장할 공간 선언 및 5개 배열 생성
		int[] intArray = new int[5];
		
		for(int i=0; i<intArray.length; i++) { //intArray 배열 크기만큼 루프
			intArray[i] = scanner.nextInt(); // 정수를 배열에 저장
		}
		
		
		
		
		
		System.out.print("변경된 수는");
		
		scanner.close();
		
	} //main

} //class
