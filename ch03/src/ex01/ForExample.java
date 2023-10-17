package ex01;

public class ForExample {

	public static void main(String[] args) {
		// for (1.초기식(1번만);2.조건;4.실행후)

		// for (조건 참(true)동안) // 제일 많이 쓰이는 것
		// 횟수를 예상(알) 할 수 있는 경우

		// for(처음 1번 할 거; 조건; 나중에 할 거){
		// 반복할 부분
		// }

		// while (조건 참(true)동안)
		// 예측을 할 수 없는 경우

		// do (한다) - while (조건 참(ture)동안)
		// 예측을 할 수 없는 경우
		// 최소 1회는 하고 싶은 경우

		for (int count = 1; count <= 10; count++) {
			System.out.println(count + ":Hello");
		}

		// 1부터 10까지의 누적 합계
		// 1 + 2 + 3 + ... + 10 = ?

		int sum = 0;

		for (int count = 1; count <= 100; count++) {
			sum += count; // sum = sum + count; // 1 -> 3- > 6
		}

		// sum += 2;
		// sum += 3;
		
		System.out.println("합계:" + sum);
		System.out.println("프로그램 종료");

	}

}