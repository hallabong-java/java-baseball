package me.lxxjn0.game.controller;

import static me.lxxjn0.game.view.InputView.*;
import static me.lxxjn0.game.view.OutputView.*;

import me.lxxjn0.game.domain.baseball.Baseballs;
import me.lxxjn0.game.domain.baseballGame.GameResult;
import me.lxxjn0.game.domain.baseballGame.Opinion;
import me.lxxjn0.game.domain.numberGenerator.NumberGenerator;

public class GameController {

	private final NumberGenerator targetNumberGenerator;

	public GameController(final NumberGenerator targetNumberGenerator) {
		this.targetNumberGenerator = targetNumberGenerator;
	}

	public void run() {
		Opinion opinion;

		do {
			play();
			opinion = Opinion.of(receiveContinueOpinion());
		} while (opinion.isContinue());

		printFinish();
	}

	private void play() {
		GameResult gameResult;
		Baseballs guess;
		Baseballs target = Baseballs.of(targetNumberGenerator.generate());

		do {
			guess = Baseballs.of(receiveGuessNumbers());
			gameResult = GameResult.of(target, guess);
			printGameResult(gameResult.log());
		} while (gameResult.isFail());

		printCorrect();
	}

}
