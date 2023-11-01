package ex01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWritereEx {

	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("D:/Temp/test.txt", true);
			InputStreamReader reader = new InputStreamReader(System.in);
			while (true) {
				int data = reader.read();
				if (data == -1) { // Ctrl + z
					break;
				}
				writer.write(data);
			}
			System.out.println("파일 쓰기 완료");
			writer.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
