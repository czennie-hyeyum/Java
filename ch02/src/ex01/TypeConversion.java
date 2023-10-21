package ex01;

public class TypeConversion {

	public static void main(String[] args) {
		// 컴파일러는 값을 확인하지 않는다!! - > 타입만 본다
		// 자동 형변환
		int n = 300; // 정수형, 4바이트(-21억~21억) / 정수형, 1바이트(-128~127)
		int b = n; 

		// 자바의 연산(정수-int, 실수-double)
		int i = 300; // 4바이트
		long l = i; // 8바이트

		// 강제 형변환
		long l2 = 1000L;
		int i2 = (int) l2; // long -> int 강제 변환

		// 형변환은 같은 부류끼리만 가능
//		int i = (int)"3" // 에러

		double d = 3.14;
		int i3 = (int) d;
		System.out.println(i3); // 3

		double d2 = 3.7;
		int i4 = (int) d2;
		System.out.println(i4); // 반올림 X (소수점 이하를 무조건 자른다.)

		int kor = 75;
		int eng = 72;
		int math = 71;

		int total = kor + eng + math; // 218
		System.out.println("total:" + total);
		double average = (double) total / 3; //
		System.out.println("total:" + average);
	}

}
