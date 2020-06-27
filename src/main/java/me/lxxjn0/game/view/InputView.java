package me.lxxjn0.game.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
	}

	public static String receiveGuessNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return SCANNER.nextLine();
	}

	public static String receiveContinueOpinion() {
		System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력해주세요.");
		return SCANNER.nextLine();
	}

}
