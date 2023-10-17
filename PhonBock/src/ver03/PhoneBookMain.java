package ver03;

import java.util.Scanner;

import ver02.PhoneBook;
import ver02.PhoneInfo;

public class PhoneBookMain { 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PhoneBook book = new PhoneBook();
		
		System.out.println("===== 전화번호부 ver03 =====");
		System.out.println("----------------------");
		System.out.println("1.입력 2.전체조회 3.종료");
		System.out.println("----------------------");
		
		while(true) {
			System.out.print("선택> ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1: 
				System.out.print("이름: ");
				String name = scanner.nextLine();
				
				System.out.print("전번: ");
				String phonenum = scanner.nextLine();
				
				System.out.print("생일: ");
				String birthday = scanner.nextLine();
				System.out.println("--------------");
				
				PhoneInfo info = new PhoneInfo(name, phonenum, birthday);
				book.addInfo(info);
				break;
				
			case 2:
				book.showAll();
				break;
				
			case 3:
				scanner.close();
				System.out.println("===== 프로그램 종료 =====");
				System.exit(0);
				break;
			} // switch
		
		} // while
	
	} // main
	
} // class

