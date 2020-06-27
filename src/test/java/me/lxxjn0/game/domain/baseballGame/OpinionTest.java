package me.lxxjn0.game.domain.baseballGame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OpinionTest {

	@DisplayName("of() - 사용자로부터 받은 문자열에 해당하는 객체 생성")
	@Test
	void of_OpinionByString_GenerateInstance() {
		assertThat(Opinion.of("1")).isInstanceOf(Opinion.class);
	}

	@DisplayName("isContinue() - 게임을 계속 진행하는지에 대한 응답을 확인")
	@Test
	void isCorrect_UserOpinion_CheckIsContinue() {
		assertThat(Opinion.CONTINUE.isContinue()).isTrue();
		assertThat(Opinion.FINISH.isContinue()).isFalse();
	}

}
