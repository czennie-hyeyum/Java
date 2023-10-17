package ex02;

public class LottoMain {

	public static void main(String[] args) {
		// 1~10번까지는 노란색
		// 11~20번은 파란색
		// 21~30번은 빨간색
		// 31~40번은 회색
		// 41~45번은 녹색
		
		LottoBall aBall = new LottoBall(1, "Yellow");
		aBall.showInfo();
		System.out.println("-------------");
		
		// 공 45개 넣기
		LottoBall[] balls = new LottoBall[45]; // {null, null, ..., null}
		
		// 번호에 맞는 공 만들기
		for(int i=0; i<balls.length; i++) {
			String color = "";
			if(0 <= i && i < 10) {
				color = "Yellow";
			} else if(10 <= i && i <20) {
				color = "Blue";
			} else if(20 <= i && i <30) {
				color = "Red";
			} else if(30 <= i && i <40) {
				color = "Gray";
			} else if(40 <= i && i < balls.length) {
				color = "Green";
			}
			balls[i] = new LottoBall(i + 1, color);
		}
		
		// 섞기 - 0번째 <- 임의의 위치 ->  스와핑
		for (int i = 0; i < balls.length *2; i++) {
			LottoBall tempBall = balls[0];
			int rand = (int)(Math.random() * 44) + 1; // 1 ~ 44번째
			balls[0] = balls[rand];
			balls[rand] = tempBall;
		}
		
		/*
		for (LottoBall ball : balls) {
			ball.showInfo();
		}
		*/
		
		// 6개 공만 나오게
		for(int i = 0; i < 6; i++) {
			balls[i].showInfo();
		}
		
	}

}
