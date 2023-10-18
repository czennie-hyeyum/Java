package ex02;

import java.util.Scanner;

public class ArrayAccess {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] intArray = new int[5];
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("입력: ");
			intArray[i] = scanner.nextInt();
		}
		
		System.out.println("intArray:" + intArray); 
		
		System.out.println("--- intArray ---");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");		
		}
		
		int max = 0;
		
		/*
		for (int i = 0; i < intArray.length; i++) {
			if (max < intArray[i]) {
			max = intArray[i];
			}
		}
		*/
		
		// for - each (enhanced for-향상된 for)
		for (int n : intArray) {
			if (max < n) {
				max = n;
			}
		}
		
		System.out.println("가장 큰 값: " + max);
		
		scanner.close();
	}

}
