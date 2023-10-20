package ex01;

public class PointMain {

	public static void main(String[] args) {
		Point p1 = new Point(10, 10);
		Point p2 = new Point(10, 10);
		Point p3 = new Point(20, 20);
		
		// 객체가 같은지를 비교할 때는 .equals()를 사용
		System.out.println(p1 == p2); // false
		System.out.println(p1.equals(p2)); // true
		System.out.println(p1 == p3); // false
		System.out.println(p1.equals(p3)); // false
		
	}

}
