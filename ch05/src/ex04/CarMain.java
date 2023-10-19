package ex04;

public class CarMain {

	public static void main(String[] args) {
		
		// Car의 drive() 실행. "부웅~~" 출력
		Car c1 = new Car();
		c1.drive();
		
		// SuperCar의 drive() 실행. "부앙~~" 출력
		SuperCar sc1 = new SuperCar();
		sc1.drive();
		
		// Car -> SuperCar로 업캐스팅
		// 오버라이딩된 메소드 SuperCar의 drive() 실행, "부앙~~" 출력
		Car c2 = new SuperCar();
		c2.drive();
		
	}

}
