package info.twobteam.algorithms.fibonacci;

public class FibonacciStrategy {
	public int computeIterative(int i) {
		if (i < 3) {
			return 1;
		} else {
			int first = 1;
			int second = 1;

			for (int k = 3; k <= i; ++k) {
				second = first + second;
				first = second - first;
			}

			return second;
		}
	}
}
