package ex03;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TextCopy {

	public static void main(String[] args) {
		File src = new File("C:/Windows/system.ini");
		File dest = new File("D:/Temp/system.txt");
		
		try {
			FileReader reader = new FileReader(src);
			FileWriter writer = new FileWriter(dest);
			while (true) {
				int data = reader.read();
				if (data == -1) {
					break;
				}
				writer.write(data);
			}
			System.out.println("파일 복사 완료");
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
