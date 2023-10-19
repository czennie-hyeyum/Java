package ex04;

public class UnitMain {
	public static void main(String[] args) {
		Unit[] group1 = {new Marine("마린1"), new Tank("탱크1"), new Scout("스카1")};
		
		// (200, 200)으로 그룹1 이동
		for (Unit unit : group1) {
			unit.move(200, 200);
		}
		
		// 그룹1 위치 확인
		for (Unit unit : group1) {
			unit.showPostion();
		}
		
		// (300, 300) 공격
		for (Unit unit : group1) {
			unit.atack(300, 300);
		}
		
		
	}

}
