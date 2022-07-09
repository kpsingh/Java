package com.java.hackerrank;

public class NoOfRotationInArray {

	public static void main(String[] args) {

		// int[] arr = { 3, 4, 5, 1, 2 };

		// int[] arr = { 1, 2, 3, 4, 5 };

		// int[] arr = { 5, 1, 2, 3, 4 };

		int[] arr = { 3, 4, 5, 6, 7, 1, 2 };

		int noOfRotation = getRotation(arr);

		System.out.println(noOfRotation);

	}

	private static int getRotation(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {

			int mid = start + (end - start) / 2;

			if (mid > 0 && mid < end) {
				if (arr[mid] < arr[mid - 1] & arr[mid] < arr[mid + 1]) {
					return mid - 1;
				} else if (arr[mid] > arr[0]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

			if (mid == 0) {
				return 1;
			}

			if (mid == end) {
				return 0;
			}

		}

		return 0;

	}

}
