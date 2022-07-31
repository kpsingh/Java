package com.java.lambda;

import java.util.function.Predicate;

public class PredicateNumber {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 12, 24, 33, 16, 55 };

		System.out.println("Number > 10 & Even");

		Predicate<Integer> p = i -> i % 2 == 0;

		Predicate<Integer> p1 = i -> i > 10;

		for (int a : arr) {

			if (p1.and(p).test(a)) {
				System.out.println(a);
			}

		}

	}

}
