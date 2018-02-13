package info.twobteam.algorithms;

import info.twobteam.algorithms.fibonacci.FibonacciStrategy;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciStrategyTest {
	@Test
	public void shouldComputeOne() {
		assertThat(new FibonacciStrategy().computeIterative(1), is(1));
	}

	@Test
	public void shouldComputeTwo() {
		assertThat(new FibonacciStrategy().computeIterative(2), is(1));
	}

	@Test
	public void shouldComputeEleven() {
		assertThat(new FibonacciStrategy().computeIterative(11), is(89));
	}
}
