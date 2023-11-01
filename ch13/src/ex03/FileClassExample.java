package ex03;

import java.io.File;
import java.util.Calendar;

public class FileClassExample {

	public static void main(String[] args) {
		String fileName = "C:/Windows/system.ini";
		// 파일 객체 생성 (파일을 생성하는 것이 아님)
		File f = new File(fileName);
		System.out.println(f);
		System.out.println(f.exists()); // 파일 존재 여부
		System.out.println(f.getName()); // 이름만
		System.out.println(f.getPath()); // 경로 포함
		System.out.println(f.getParent()); // 경로만
		System.out.println(f.length()); // 파일의 크기
		System.out.println(f.isFile()); // 파일인가에 대하여
		System.out.println(f.isDirectory()); // 디렉토리인가에 대하여
		System.out.println(f.lastModified()); // 마지막으로 수정된 시간
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(f.lastModified());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String strDate = year + "-" + month + "-" + date + " ";
		strDate += hour + ":" + minute + ":" + second;
		System.out.println(strDate);
		
		File f2 = new File("D:/Temp/mydir");
		if (!f2.exists()) {
			boolean b = f2.mkdir();
			if (b) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		}
		
		File f3 = new File("D:/Temp/yourdir/hisdir/herdir");
		f3.mkdirs();
		
		File f4 = new File("D:/Temp");
		String[] list = f4.list();
		for (String str : list) {
			System.out.println("str: " + str);
		}
		
		File[] files = f4.listFiles();
		for (File aFile : files) {
			System.out.println(aFile.getName() + ": " + aFile.length() + "bytes");
			
			if (aFile.getName().equals("test.out")) {
				aFile.renameTo(new File("D:/Temp/test2.out"));
				System.out.println("파일 이름 변경 완료 되었습니다.");
			}
		}
		
		File f5 = new File("D:/Temp/target.txt");
		if (f5.exists()) {
			boolean b = f5.delete();
			if (b) {
				System.out.println("파일이 삭제 되었습니다.");
			}
		}
		
	}

}
