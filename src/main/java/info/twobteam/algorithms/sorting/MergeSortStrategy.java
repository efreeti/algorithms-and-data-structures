package info.twobteam.algorithms.sorting;

public class MergeSortStrategy {
	public int[] merge(int[] sortedHalf1, int[] sortedHalf2) {
			int[] result = new int[sortedHalf1.length + sortedHalf2.length];
			int i = 0;
			int k = 0;

			while (i < sortedHalf1.length || k < sortedHalf2.length) {
				if (i < sortedHalf1.length && k < sortedHalf2.length) {
					if (sortedHalf1[i] < sortedHalf2[k]) {
						result[i + k] = sortedHalf1[i];
						++i;
					} else {
						result[i + k] = sortedHalf2[k];
						++k;
					}
				} else if (i < sortedHalf1.length) {
					result[i + k] = sortedHalf1[i];
					++i;
				} else {
					result[i + k] = sortedHalf2[k];
					++k;
				}
			}

			return result;
	}

	public int[] sort(int[] input, int start, int end) {
		if (end > start) {
			int median = start + (end - start + 1) / 2;

			return merge(sort(input, start, median - 1), sort(input, median, end));
		} else {
			return new int[] {input[start]};
		}
	}

	public int[] sort(int[] input) {
		return sort(input, 0, input.length - 1);
	}
}
