package info.twobteam.structures.queues;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class HeapTest {
	private static final Comparator<Integer> COMPARATOR = (item1, item2) -> item1.compareTo(item2);

	@Test
	public void shouldComputeParentForChild() {
		// [*   *  *    *  *  *  *]
		//      ^          ^
		assertThat(new Heap<>(COMPARATOR).computeParentIndex(4), is(1));
		// [*   *  *    *  *  *  *]
		//         ^          ^
		assertThat(new Heap<>(COMPARATOR).computeParentIndex(5), is(2));
	}

	@Test
	public void shouldComputeParentForRoot() {
		// [*   *  *    *  *  *  *]
		//  ^
		assertThat(new Heap<>(COMPARATOR).computeParentIndex(0), is(-1));
	}

	@Test
	public void shouldComputeLeftChildForRoot() {
		// [*   *  *    *  *  *  *]
		//  ^   ^
		assertThat(new Heap<>(COMPARATOR).computeLeftChildIndex(0), is(1));
	}

	@Test
	public void shouldComputeRightChildForRoot() {
		// [*   *  *    *  *  *  *]
		//  ^      ^
		assertThat(new Heap<>(COMPARATOR).computeRightChildIndex(0), is(2));
	}

	@Test
	public void shouldComputeLeftChildForChild() {
		// [*   *  *    *  *  *  *]
		//         ^          ^
		assertThat(new Heap<>(COMPARATOR).computeLeftChildIndex(2), is(5));
	}

	@Test
	public void shouldComputeRightChildForChild() {
		// [*   *  *    *  *  *  *]
		//         ^             ^
		assertThat(new Heap<>(COMPARATOR).computeRightChildIndex(2), is(6));
	}

	@Test
	public void shouldSort() {
		Heap<Integer> heap = new Heap<>((number1, number2) -> number1.compareTo(number2));
		heap.add(13);
		heap.add(1);
		heap.add(3);
		heap.add(42);
		heap.add(31);

		assertThat(heap.poll().get(), is(1));
		assertThat(heap.poll().get(), is(3));
		assertThat(heap.poll().get(), is(13));
		assertThat(heap.poll().get(), is(31));
		assertThat(heap.poll().get(), is(42));
		assertThat(heap.poll().isPresent(), is(false));
	}
}
