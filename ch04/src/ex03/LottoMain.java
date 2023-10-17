package ex03;

public class LottoMain {

	public static void main(String[] args) {
		LottoMachine machine = new LottoMachine();
		machine.setBalls();
		machine.shuffle();
		System.out.println("-----모든 공 보기-----");
		machine.showAllBalls();
		System.out.println("-----공 6개만 보기-----");
		machine.show6Balls();
	}

}
