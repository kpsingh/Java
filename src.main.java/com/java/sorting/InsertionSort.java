package com.java.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 9, 5, 1, 4, 7, 6, 3, 2, 8 };
		inserstionSort(arr);
		System.out.print(Arrays.toString(arr));
	}

	private static void inserstionSort(int[] arr) {
		if (arr.length <= 1)
			return;

		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
