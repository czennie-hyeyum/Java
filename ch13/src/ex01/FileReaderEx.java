package ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	
	public static void main(String[] args) {
		// 507p 예제 13-1
//		String fileName = "C:/Windows/system.ini"; // 읽을 파일의 경로를 'fileName' 변수에 저장
		String fileName = "D:/Temp/number.txt"; // 읽을 파일의 경로를 'fileName' 변수에 저장
		try {
			FileReader reader = new FileReader(fileName); // 스트림 개설(지정된 파일 'fileName'을 읽기 위한 FileReader 객체 생성)
			while(true) {
				int data = reader.read(); // 파일에서 다음 문자의 유니코드 값을 읽어 'data' 변수에 저장, 파일의 끝에 도달하면 '-1'을 반환
				// System.out.println(data); // 59
				if (data == -1) { // 파일의 끝에 도달했는지 확인 / -1은 EOF(End Of File)
					break;
				}
//				System.out.print((char)data); // 현재 읽은 문자를 화면에 출력(data 변수에 저장된 유니코드 값을 문자로 변환하여 출력)
				System.out.print(data + " "); // 현재 읽은 문자를 화면에 출력(data 변수에 저장된 유니코드 값을 문자로 변환하여 출력)
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중에 문제가 발생했습니다.");
		}
		
		
	}

}
