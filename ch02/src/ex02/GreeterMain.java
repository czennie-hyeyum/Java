package ex02;

public class GreeterMain {

	public static void main(String[] args) {
		Greeter g1 = new Greeter();
		System.out.println(g1.위);
		g1.sayHello();
		g1.위 = "농구공";
		System.out.println(g1.위);
	}

}

class Greeter {	//class 개체 생성
	
	String name = "Tom";
	String 위 = "밥";
	
	
	public void sayHello() {	
		System.out.println("Hello");
	}
}