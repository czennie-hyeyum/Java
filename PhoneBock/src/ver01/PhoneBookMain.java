package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneInfo info1 = new PhoneInfo("한현수", "010-1111-1111");
		PhoneInfo info2 = new PhoneInfo("김동영", "010-2222-2222", "2000.01.01");
		PhoneInfo[] infos = {info1, info2};
		
		/*
		info1.showinfo();
		info2.showinfo();
		*/
		
		PhoneInfo temp = infos[0];
		infos[0] = infos[1];
		infos[1] = temp;
		
		for (PhoneInfo aInfo : infos) {
			aInfo.showinfo();
		}
	}

}
