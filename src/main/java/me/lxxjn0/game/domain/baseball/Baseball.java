package me.lxxjn0.game.domain.baseball;

import java.util.Objects;

public class Baseball {

	public static final int LOWER_BOUND = 1;
	public static final int UPPER_BOUND = 9;

	private final int number;

	public Baseball(final int number) {
		validate(number);
		this.number = number;
	}

	private void validate(final int number) {
		if (number < LOWER_BOUND || number > UPPER_BOUND) {
			throw new IllegalArgumentException("유효하지 않은 숫자입니다.");
		}
	}

	@Override
	public boolean equals(final Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		final Baseball that = (Baseball)object;
		return this.number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.number);
	}

}
