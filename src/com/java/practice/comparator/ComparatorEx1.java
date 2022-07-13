package com.java.practice.comparator;

import java.util.Arrays;

public class ComparatorEx1 {

	public static void main(String[] args) {

		Integer[] arr = { 1, 5, 3, 7, 2, 77, 34, 22 };

		String[] str = { "abc", "kml", "aaa", "abbc", "zy", "adc" };

		// Arrays.sort(arr,Collections.reverseOrder());

		Arrays.sort(arr, (a, b) -> b.compareTo(a));

		Arrays.sort(str, (a, b) -> b.compareTo(a));

		for (int a : arr) {
			System.out.print(a + " ");
		}

		for (String s : str) {
			System.out.print(s + " ");

		}

	}
}
