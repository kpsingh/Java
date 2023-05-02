package com.java.sorting;

public class SearchInRotatedSOrtedArray {

	public static void main(String[] args) {

		int[] arr = { 7, 7, 7, 7, 7, 7, 7 };
		int target = 7;

		int left = findLeft(arr, target);
		// System.out.println(left);

		int right = findRight(arr, target);
		System.out.println("[" + left + ", " + right + "]");

	}

	private static int findLeft(int[] arr, int target) {

		int low = -1;
		int hi = arr.length - 1;

		while (low + 1 < hi) {
			int mid = low + (hi - low) / 2;

			if (arr[mid] < target) {
				low = mid;
			} else {
				hi = mid;
			}

		}

		return arr[hi] == target ? hi : -1;

	}

	private static int findRight(int[] arr, int target) {

		int low = 0;
		int hi = arr.length;

		while (low + 1 < hi) {

			int mid = low + (hi - low) / 2;

			if (arr[mid] <= target) {
				low = mid;
			} else {
				hi = mid;
			}

		}

		return arr[low] == target ? low : -1;

	}

}
