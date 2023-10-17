package ex01;

public class Hello {

	public static void main(String[] args) {
		int value = sum(5, 10);
		System.out.println(value);
		String str = "Hello\nJava";
		System.out.println(str);
		str = "She said \"I Love You.\"";
		System.out.println(str);
		str = "G:\\workspace\\java\\ch02\\src\\ex01";
		System.out.println(str);
		final double PI = 3.141592;
		double radius = 10;
		double area = PI * radius * radius;
		System.out.println("면적:" + "area");
	}

	public static int sum(int n, int m) {
		int result = n + m; // 15
		return result;
	}
}
