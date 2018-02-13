package info.twobteam.algorithms.sorting;

public class QuickSortStrategy {
	public void swap(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}

	public void sort(int[] array, int start, int end) {
		if (end - start == 1) {
			if (array[start] > array[end]) {
				swap(array, start, end);
			}
		} else if (end > start) {
			int pivot = array[(end + start) / 2];
			int i = start;
			int k = end;

			while (i < k) {
				if (array[i] < pivot) {
					++i;
				} else if (array[k] > pivot) {
					--k;
				} else {
					if (i <= k) {
						swap(array, i, k);
						++i;
						--k;
					}
				}
			}

			sort(array, start, i - 1);
			sort(array, i, end);
		}
	}

	public void sort(int[] input) {
		sort(input, 0, input.length - 1);
	}
}
