package info.twobteam.algorithms.sorting;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuickSortStrategyTest {
	@Test
	public void shouldSortLong() {
		int[] array = new int[] {12, 4, 452, 5, 23, 4, 5, 1, 3, 9, 54, 43, 87, 78, 125, 90};
		new QuickSortStrategy().sort(array);

		assertThat(array[0], is(1));
		assertThat(array[1], is(3));
		assertThat(array[2], is(4));
		assertThat(array[3], is(4));
		assertThat(array[4], is(5));
		assertThat(array[5], is(5));
		assertThat(array[6], is(9));
		assertThat(array[7], is(12));
		assertThat(array[8], is(23));
		assertThat(array[9], is(43));
		assertThat(array[10], is(54));
		assertThat(array[11], is(78));
		assertThat(array[12], is(87));
		assertThat(array[13], is(90));
		assertThat(array[14], is(125));
		assertThat(array[15], is(452));
	}

	@Test
	public void shouldSortTricky() {
		int[] array = new int[] {1, 2, 5, 4, 3};
		new QuickSortStrategy().sort(array);

		assertThat(array[0], is(1));
		assertThat(array[1], is(2));
		assertThat(array[2], is(3));
		assertThat(array[3], is(4));
		assertThat(array[4], is(5));
	}
}