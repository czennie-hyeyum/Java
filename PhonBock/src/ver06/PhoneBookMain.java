package ver06;

import java.util.Scanner;

public class PhoneBookMain {
	private static final int INPUT = 1;
	private static final int EXIT = 3;
	private static final int SHOW_ALL = 2;
	private static final int INPUT_TEST_DATA = 99;
	private static final int SCHOOL = 1;
	private static final int COMPANY = 2;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PhoneBook book = new PhoneBook();
		
		System.out.println("===== 전화번호부 ver.06 =====");
		
		while (true) {
			MenuViewer.showMenu();
			System.out.print("선택> ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case INPUT:
				MenuViewer.showSubMenu();
				System.out.print("세부선택> ");
				int subChoice = scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("이름: ");
				String name = scanner.nextLine();
				
				System.out.print("전번: ");
				String phoneNumber = scanner.nextLine();
				
				System.out.print("생일: ");
				String birthDay = scanner.nextLine();
				
				PhoneInfo info = null;
				
				switch (subChoice) {
					case SCHOOL:
						System.out.print("학교: ");
						String school = scanner.nextLine();
						info = new PhoneInfoSchool(name, phoneNumber, birthDay, school);
					
					case COMPANY:
						System.out.print("회사: ");
						String company = scanner.nextLine();
						info = new PhoneInfoCompany(name, phoneNumber, birthDay, company);
				}

				try {
					book.addInfo(info);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("저장 용량이 다 찼어요");
				}
				break;
				
			case SHOW_ALL:
				book.showAll();
				break;
				
			case EXIT:
				scanner.close();
				System.out.println("===== 프로그램 종료 =====");
				System.exit(0);
				break;
				
			case INPUT_TEST_DATA:
				for (int i = 1; i <= 10; i++) {
					PhoneInfo infoTest = null; 
							if (i % 2 == 0) {
								new PhoneInfoSchool ("이름-" + i,
											         "전번-" + i,
											         "생일-" + i,
											         "학교-" + i);
							} else {
								new PhoneInfoCompany ("이름-" + i,
													  "전번-" + i,
													  "생일-" + i,
													  "회사-" + i);
							}
					book.addInfo(infoTest);
				}
				
				break;
			}
			
			
			
		} // while
	} // main
	
	

}