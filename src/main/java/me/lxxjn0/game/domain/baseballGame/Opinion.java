package me.lxxjn0.game.domain.baseballGame;

import java.util.Arrays;

public enum Opinion {

	CONTINUE(1),
	FINISH(2);

	private final int opinion;

	Opinion(final int opinion) {
		this.opinion = opinion;
	}

	public static Opinion of(final String opinion) {
		return Arrays.stream(values())
		             .filter(value -> value.opinion == Integer.parseInt(opinion))
		             .findFirst()
		             .orElseThrow(() -> new IllegalArgumentException("1 또는 2만 입력 가능합니다."));
	}

	public boolean isContinue() {
		return CONTINUE.equals(this);
	}

}
