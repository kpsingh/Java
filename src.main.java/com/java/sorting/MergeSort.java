package com.java.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 6, 4, 2, 3, 7, 5 };
		arr = sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	private static int[] sort(int[] arr, int low, int high) {

		if (low == high) {

			return new int[] { arr[low] };
		}

		int mid = low + (high - low) / 2;
		
		// assume that left and right array will be garbage collected immediately once call go back 

		int[] left = sort(arr, low, mid);

		int[] right = sort(arr, mid + 1, high);

		return merge(left, right);

	}

	private static int[] merge(int[] left, int[] right) {

		int n = left.length;
		int m = right.length;

		// space complexity will be O(n).. since it worst case it storing all the input
		int[] result = new int[n + m];

		int i = 0, j = 0, k = 0;

		while (i < n && j < m) {

			if (left[i] < right[j]) {
				result[k++] = left[i++];

			} else {
				result[k++] = right[j++];
			}

		}

		while (i < n) {
			result[k++] = left[i++];
		}
		while (j < m) {
			result[k++] = right[j++];
		}

		return result;

	}

}
