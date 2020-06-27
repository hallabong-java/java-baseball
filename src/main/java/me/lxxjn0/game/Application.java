package me.lxxjn0.game;

import me.lxxjn0.game.controller.GameController;
import me.lxxjn0.game.domain.numberGenerator.RandomNumberGenerator;

public class Application {

	public static void main(String[] args) {
		try {
			final GameController controller = new GameController(new RandomNumberGenerator());
			controller.run();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
