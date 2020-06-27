package me.lxxjn0.game.domain.baseballGame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.lxxjn0.game.domain.baseball.Baseballs;

class GameResultTest {

	@DisplayName("of() - 사용자가 입력한 Baseballs와 타겟 Baseballs를 입력받아 객체 생성")
	@Test
	void of_GuessBaseballsAndTargetBaseballs_GenerateInstance() {
		final Baseballs target = Baseballs.of(2, 3, 4);
		final Baseballs guess = Baseballs.of(1, 2, 3);

		assertThat(GameResult.of(target, guess)).isInstanceOf(GameResult.class);
	}

	@DisplayName("isCorrect() - 게임 결과가 정답인지 여부를 확인")
	@Test
	void isCorrect_MatchResultOfGuessAndTarget_ReturnCorrectResult() {
		final Baseballs target = Baseballs.of(1, 2, 3);
		final Baseballs correct = Baseballs.of(1, 2, 3);
		final Baseballs incorrect = Baseballs.of(2, 3, 4);

		assertThat(GameResult.of(target, incorrect).isFail()).isTrue();
		assertThat(GameResult.of(target, correct).isFail()).isFalse();
	}

	@DisplayName("log() - 게임 결과를 로그로 반환")
	@Test
	void log_GameResult_ReturnLogByString() {
		final Baseballs target = Baseballs.of(1, 2, 3);
		final Baseballs oneStrikeTwoBall = Baseballs.of(1, 3, 2);
		final Baseballs oneBall = Baseballs.of(3, 5, 9);
		final Baseballs nothing = Baseballs.of(4, 5, 6);

		assertThat(GameResult.of(target, oneStrikeTwoBall).log()).isEqualTo("1스트라이크, 2볼");
		assertThat(GameResult.of(target, oneBall).log()).isEqualTo("1볼");
		assertThat(GameResult.of(target, nothing).log()).isEqualTo("낫싱");
	}

}
