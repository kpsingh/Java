package com.java.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 9, 5, 1, 4, 7, 6, 3, 2, 8 };
		quickSort(arr, 0, arr.length - 1);
		System.out.print(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int hi) {
		if (low >= hi)
			return;

		int pivotIdx = partition(arr, low, hi);
		quickSort(arr, low, pivotIdx - 1);
		quickSort(arr, pivotIdx + 1, hi);

	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int j = start;

		for (int i = start; i <= end; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, j);
				j++;
			}
		}
		swap(arr, j, end);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
