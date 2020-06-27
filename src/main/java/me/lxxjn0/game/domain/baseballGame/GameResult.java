package me.lxxjn0.game.domain.baseballGame;

import java.util.ArrayList;
import java.util.List;

import me.lxxjn0.game.domain.baseball.Baseballs;

public class GameResult {

	private static final String NOTHING_LOG = "낫싱";
	private static final String STRIKE_LOG = "스트라이크";
	private static final String BALL_LOG = "볼";
	private static final String DELIMITER = ", ";

	private final int strikeCounts;
	private final int ballCounts;

	private GameResult(final int strikeCounts, final int ballCounts) {
		this.strikeCounts = strikeCounts;
		this.ballCounts = ballCounts;
	}

	public static GameResult of(final Baseballs target, final Baseballs guess) {
		final int strikeCounts = guess.countStrikes(target);
		final int ballCounts = guess.countBalls(target);

		return new GameResult(strikeCounts, ballCounts);
	}

	public boolean isFail() {
		return strikeCounts != Baseballs.VALID_SIZE;
	}

	public String log() {
		if (isNothing()) {
			return NOTHING_LOG;
		}

		return String.join(DELIMITER, logGameResult());
	}

	private boolean isNothing() {
		return strikeCounts == 0 && ballCounts == 0;
	}

	private List<String> logGameResult() {
		final List<String> gameLog = new ArrayList<>();

		if (strikeCounts != 0) {
			gameLog.add(strikeCounts + STRIKE_LOG);
		}

		if (ballCounts != 0) {
			gameLog.add(ballCounts + BALL_LOG);
		}

		return gameLog;
	}

}
