package me.lxxjn0.game.domain.baseball;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Baseballs {

	public static final int VALID_SIZE = 3;

	private final List<Baseball> baseballs;

	public Baseballs(final List<Baseball> baseballs) {
		validate(baseballs);
		this.baseballs = baseballs;
	}

	public static Baseballs of(final List<Integer> numbers) {
		return new Baseballs(
			numbers.stream()
			       .map(Baseball::new)
			       .collect(toList()));
	}

	public static Baseballs of(final int... numbers) {
		return new Baseballs(
			Arrays.stream(numbers)
			      .mapToObj(Baseball::new)
			      .collect(toList()));
	}

	public static Baseballs of(final String guessNumbers) {
		return IntStream.range(0, guessNumbers.length())
		                .mapToObj(guessNumbers::charAt)
		                .map(Character::getNumericValue)
		                .map(Baseball::new)
		                .collect(collectingAndThen(
			                toList(),
			                Baseballs::new));
	}

	private void validate(final List<Baseball> baseballs) {
		validateSize(baseballs);
		validateDuplication(baseballs);
	}

	private void validateSize(final List<Baseball> baseballs) {
		if (baseballs.size() != VALID_SIZE) {
			throw new IllegalArgumentException("숫자의 개수가 유효하지 않습니다.");
		}
	}

	private void validateDuplication(final List<Baseball> baseballs) {
		final HashSet<Baseball> distinctBaseballs = new HashSet<>(baseballs);

		if (baseballs.size() != distinctBaseballs.size()) {
			throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
		}
	}

	public boolean isNothing(final Baseballs comparison) {
		return comparison.baseballs.stream()
		                           .noneMatch(this.baseballs::contains);
	}

	public int countStrikes(final Baseballs comparison) {
		return (int)IntStream.range(0, VALID_SIZE)
		                     .filter(index -> this.baseballs.get(index).equals(comparison.baseballs.get(index)))
		                     .count();
	}

	public int countBalls(final Baseballs comparison) {
		final int strikeCounts = countStrikes(comparison);
		final int sameCounts = (int)comparison.baseballs.stream()
		                                                .filter(this.baseballs::contains)
		                                                .count();
		return sameCounts - strikeCounts;
	}

}
