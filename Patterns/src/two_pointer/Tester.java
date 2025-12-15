package two_pointer;

import java.util.List;

public class Tester {

	public static void main(String[] args) {
		SortedPairSum sps = new SortedPairSum();		
//		int[] arr = {2,2,3};	
		int[] arr = {1,1,1};
//		List<Pair> result = sps.pair_sum_sorted(arr,-5);
		List<int[]> result = sps.pair_sum_sorted(arr, 2);
		result.stream().forEach(val -> System.out.println("["+val[0]+","+val[1]+"]"));
//		System.out.println(result);
	}
}
