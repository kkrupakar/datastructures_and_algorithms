package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRecursion {
	
	public static void main(String[] args) {
		int[] data = { 3,6,72,7,23,22,2,34};
//		int result = RecursionExamples.binaryMaxInArray(data, 0, data.length - 1);
//		double result = RecursionExamples.power(2.0, 10);
//		System.out.println("Result : "+result);
		
		List<Character> U = new ArrayList<>(Arrays.asList('A','B','C'));
		RecursionExamples.GenericPuzzleSolve(U.size() - 1, new ArrayList<>(), U);
	}

}
