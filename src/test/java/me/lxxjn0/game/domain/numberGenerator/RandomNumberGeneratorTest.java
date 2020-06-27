package me.lxxjn0.game.domain.numberGenerator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	@DisplayName("generate() - 1부터 9까지의 숫자를 중복되지 않게 3개 생성")
	@Test
	void generate_Nothing_DistinctListOfNumbers() {
		final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		final List<Integer> numbers = randomNumberGenerator.generate();

		assertThat(numbers).hasSize(3);
		assertThat(numbers).asList().doesNotHaveDuplicates();
	}

}
