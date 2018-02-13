package info.twobteam.algorithms.sorting;

import info.twobteam.algorithms.graphs.DijkstraStrategy;
import info.twobteam.structures.graphs.Graph;
import info.twobteam.structures.graphs.GraphEdge;
import info.twobteam.structures.graphs.GraphNode;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MergeSortStrategyTest {
	@Test
	public void shouldSortLong() {
		int[] sorted = new MergeSortStrategy().sort(new int[] {12, 4, 452, 5, 23, 4, 5, 1, 3, 9, 54, 43, 87, 78, 125, 90});

		assertThat(sorted[0], is(1));
		assertThat(sorted[1], is(3));
		assertThat(sorted[2], is(4));
		assertThat(sorted[3], is(4));
		assertThat(sorted[4], is(5));
		assertThat(sorted[5], is(5));
		assertThat(sorted[6], is(9));
		assertThat(sorted[7], is(12));
		assertThat(sorted[8], is(23));
		assertThat(sorted[9], is(43));
		assertThat(sorted[10], is(54));
		assertThat(sorted[11], is(78));
		assertThat(sorted[12], is(87));
		assertThat(sorted[13], is(90));
		assertThat(sorted[14], is(125));
		assertThat(sorted[15], is(452));
	}
}