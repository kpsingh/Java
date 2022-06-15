package com.kp.java8.functional;

import java.util.function.Function;

public class FunctionEx1 {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		Function<Integer, Integer> f = i -> i * i;

		for (int a : arr) {
			System.out.print(a + " ");
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = f.apply(arr[i]);
		}

		System.out.println();

		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

}
