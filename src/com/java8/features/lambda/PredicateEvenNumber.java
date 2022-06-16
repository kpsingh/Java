package com.java8.features.lambda;

import java.util.function.Predicate;
/*
 * learning about predicate functional interface.
 */

public class PredicateEvenNumber {

	public static void main(String[] args) {

		int n = 14;

		String name = "Prasoon";

		Predicate<Integer> p = i -> i % 2 == 0;

		Predicate<String> p2 = s -> s.length() % 2 == 0;

		if (p2.test(name) && p.test(n)) {
			System.out.println("Name & Number both are EVEN length");
		} else if (p2.test(name)) {
			System.out.println("Name is even length");
		} else if (p.test(n)) {
			System.out.println("N is even length");
		} else {
			System.out.println("Name & Number both are ODD length");
		}

	}

}
