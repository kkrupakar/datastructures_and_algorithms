package Recursion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursionExamples {

	public static <T> void GenericPuzzleSolve(int K, List<T> S, List<T> U) {
		//Created a new ArrayList to resolve concurrency read and write issue
		for (T e : new ArrayList<>(U)) {
			S.add(e);
			U.remove(e);
				if (K == 0) {
					System.out.println(S);
				} else {
					GenericPuzzleSolve(K - 1, S, U);
				}
			S.remove(e);
			U.add(e);
		}
	}

	public static void PuzzleSolve(int k, String S, String U) {
		if (U.length() == 0) {
			System.out.println(S);
		}
		for (int i = 0; i < U.length(); i++) {
			PuzzleSolve(k - i, S + U.charAt(i), U.substring(0, i) + U.substring(i + 1));
		}
	}

	public static double harmonicNumber(int k, int n) {
		if (n == 0) {
			return 1;
		}
		return 1 / n + harmonicNumber(k, n - 1);
	}

	public static int maxInArray(int[] data, int length) {
		if (length == 0) {
			return data[0];
		}
		return Math.max(data[length - 1], maxInArray(data, length - 1));
	}

	public static int binaryMaxInArray(int[] data, int low, int high) {

		if (low > high) {
			return 0;
		}
		if (low == high) {
			return data[low];
		}

		int mid = (low + high) / 2;
		int left = binaryMaxInArray(data, low, mid);
		int right = binaryMaxInArray(data, mid + 1, high);
		System.out.println("low : " + low + "high : " + high + " ==> " + Math.max(left, right));
		return Math.max(left, right);
	}

	public static double linearPower(double x, int n) {
		if (n == 0) {
			return 1;
		}
		return x * linearPower(x, n - 1);
	}

	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double partial = power(x, n / 2);
		double result = partial * partial;
		if (n % 2 == 1) {
			result = result * x;
		}
		return result;
	}

	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void reverseArray(int[] data, int low, int high) {
		if (low > high) {
			return;
		}
		int temp = data[low];
		data[low] = data[high];
		data[high] = temp;
		reverseArray(data, low + 1, high - 1);
	}

	public static long arraySum(int[] data, int length) {
		if (length == 0) {
			return 0;
		}
		return data[length - 1] + arraySum(data, length - 1);
	}

	public static int binarySum(int[] data, int low, int high) {
		if (low > high) {
			return 0;
		} else if (low == high) {
			return data[low];
		} else {
			int mid = (low + high) / 2;
			return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
		}

	}

	public static long diskUsage(File root) {
		long total = root.length();
		if (root.isDirectory()) {
			for (String childPath : root.list()) {
				File child = new File(root, childPath);
				total = total + diskUsage(child);
			}
		}

		System.out.println(total + " \t " + root);

		return total;
	}

	/******* Binary Search **********/

	public static boolean binarySearch(int[] data, int low, int high, int value) {

		if (low > high) {
			return false;
		} else {

			int mid = (low + high) / 2;
			if (data[mid] < value) {
				return binarySearch(data, mid + 1, high, value);
			} else if (data[mid] > value) {
				return binarySearch(data, low, mid - 1, value);
			} else {
				return true;
			}
		}
	}

	/******* Binary Search **********/

	/******* drawing English Ruler **********/

	public static void drawRuler(int nInches, int majorLength) {
		drawLine(majorLength, 0);
		for (int j = 1; j <= nInches; j++) {
			drawInterval(majorLength - 1);
			drawLine(majorLength);
		}
	}

	private static void drawInterval(int centralLength) {
		if (centralLength > 1) {
			drawInterval(centralLength - 1);
			drawLine(centralLength);
			drawInterval(centralLength - 1);
		}

	}

	private static void drawLine(int tickLength, int tickLabel) {

		for (int j = 0; j < tickLength; j++) {
			System.out.println("-");
		}

		if (tickLabel >= 0) {
			System.out.println(" " + tickLabel);
		}
		System.out.println();
	}

	private static void drawLine(int majorLength) {
		drawLine(majorLength, -1);

	}

	/******* drawing English Ruler **********/

}
