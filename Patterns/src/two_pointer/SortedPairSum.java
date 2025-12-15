package two_pointer;

import java.util.ArrayList;
import java.util.List;

public class SortedPairSum {

	record Pair(int left, int right) {
	};

	public List<int[]> pair_sum_sorted(int arr[], int target) {

		int left = 0;
		int right = arr.length - 1;

		List<int[]> result = new ArrayList<>();

		while (left < right) {
			System.out.println("Entered Loop..!!");
			int sum = (arr[left] + arr[right]);
			if (target < sum) {
				right -= 1;
			} else if (target > sum) {
				left += 1;
			} else {
				result.add(new int[]{left, right});
				left++;
				right--;
			}

		}
		return result;
	}

}
