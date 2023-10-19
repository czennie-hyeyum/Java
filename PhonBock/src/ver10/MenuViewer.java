package ver10;

public class MenuViewer {
	// 메인메뉴
	public static void showMenu() { 
		System.out.println("------------------------------------");
		System.out.println("1.입력 2.전체조회 3.검색 4.수정 5.삭제 6.종료");
		System.out.println("------------------------------------");
	}
	
	// 서브메뉴
	public static void showSubMenu() {
		System.out.println("--------------------------");
		System.out.println("1.학교 2.회사");
		System.out.println("--------------------------");
	}
	
	// 수정 안내
	public static void modifyInfo() {
		System.out.println("--------------------------");
		System.out.println("해당 내용들을 수정해주세요.");
		System.out.println("--------------------------");
	}
	
}
