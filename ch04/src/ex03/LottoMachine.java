package ex03;

public class LottoMachine {
	// LottoMachine has-a LottoBall
	public LottoBall[] balls = new LottoBall[45];
	
	// 공 세팅
	public void setBalls() {
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
	} // setBalls()
	
	// 공 섞기
	public void shuffle() {
		for (int i = 0; i < balls.length *2; i++) {
			LottoBall tempBall = balls[0];
			int rand = (int)(Math.random() * 44) + 1; // 1 ~ 44번째
			balls[0] = balls[rand];
			balls[rand] = tempBall;
		}
	} // shuffle()
	
	// 공 6개
	public void show6Balls() {
		for(int i = 0; i < 6; i++) {
			balls[i].showInfo();
		}
	} // show6Balls()
	
	// 모든 공
	public void showAllBalls() {
		for (LottoBall ball : balls) {
			ball.showInfo();
		}
	} // showAllBalls()
}
