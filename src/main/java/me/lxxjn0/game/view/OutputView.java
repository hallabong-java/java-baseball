package me.lxxjn0.game.view;

public class OutputView {

	private OutputView() {
	}

	public static void printGameResult(final String gameResultLog) {
		System.out.println(gameResultLog);
	}

	public static void printCorrect() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static void printFinish() {
		System.out.println("게임 종료");
	}

}
