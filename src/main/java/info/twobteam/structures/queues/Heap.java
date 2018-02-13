package info.twobteam.structures.queues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Heap<Data> {
	private final List<Data> items = new ArrayList<Data>();
	private final Comparator<Data> comparator;

	public Heap(Comparator<Data> comparator) {
		this.comparator = comparator;
	}

	public int computeLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	public int computeRightChildIndex(int index) {
		return 2 * index + 2;
	}

	public int computeParentIndex(int index) {
		if (index > 0) {
			return (index - 1) / 2;
		} else {
			return -1;
		}
	}

	public boolean hasLeftChild(int index) {
		return computeLeftChildIndex(index) < items.size();
	}

	public boolean hasRightChild(int index) {
		return computeRightChildIndex(index) < items.size();
	}

	private Data getByIndex(int index) {
		if (index >= 0 && index < items.size()) {
			return items.get(index);
		} else {
			return null;
		}
	}

	private void swap(int index1, int index2) {
		Data temp = items.get(index1);
		items.set(index1, items.get(index2));
		items.set(index2, temp);
	}

	public void hipifyUp(int index) {
		int parentIndex = computeParentIndex(index);
		Data parent = getByIndex(parentIndex);
		Data item = getByIndex(index);

		while (parent != null) {
			if (comparator.compare(parent, item) > 0) {
				swap(parentIndex, index);

				index = parentIndex;
				parentIndex = computeParentIndex(index);
				parent = getByIndex(parentIndex);
			} else {
				break;
			}
		}
	}

	private void hipifyDown(int index) {
		while (hasLeftChild(index)) {
			int leftChildIndex = computeLeftChildIndex(index);
			int rightChildIndex = computeRightChildIndex(index);
			int smallerChildIndex = leftChildIndex;

			if (hasRightChild(index) && comparator.compare(getByIndex(leftChildIndex), getByIndex(rightChildIndex)) > 0) {
				smallerChildIndex = rightChildIndex;
			}

			if (comparator.compare(getByIndex(smallerChildIndex), getByIndex(index)) < 0) {
				swap(smallerChildIndex, index);
				index = smallerChildIndex;
			} else {
				break;
			}
		}
	}

	public void add(Data item) {
		items.add(item);

		hipifyUp(items.size() - 1);
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public Optional<Data> peek() {
		if (!isEmpty()) {
			return Optional.of(items.get(0));
		} else {
			return Optional.empty();
		}
	}

	public Optional<Data> poll() {
		return peek().map(item -> {
			Data last = items.get(items.size() - 1);

			items.remove(items.size() - 1);

			if (!items.isEmpty()) {
				items.set(0, last);

				hipifyDown(0);
			}

			return item;
		});
	}
}
