package com.java.practice.string;

import java.util.HashSet;
import java.util.Set;

public class PrintAllPermutationAndPowerSet {

	/*
	 * if we want to know what are all possible superset from the given String then
	 * we can use this to store all the string passed.
	 * 
	 */
	static Set<String> superSet = new HashSet<>();

	public static void main(String[] args) {

		String s = "abc";
		String ans = "";

		printPermutation_V1(s, ans);

		System.out.println(superSet);

		/*
		 * if we don't want null or empty set then we can remove from the set.
		 */

		superSet.remove("");

		System.out.println(superSet);

		/*
		 * Print in sorted manner......
		 * 
		 */

		// Natural String sorting
		superSet.stream().sorted().forEach(System.out::println);

		System.out.println("After sorting based on lexical order then based on lenghth of String");

		superSet.stream().sorted().sorted((a, b) -> a.length() < b.length() ? -1 : (a.length() > b.length() ? 1 : 0))
				.forEach(System.out::println);

	}

	private static void printPermutation_V1(String s, String ans) {

		superSet.add(s); // this collect all super/power set produced by given string

		if (s.isBlank()) {
			System.out.println(ans); // this print all permutation of string
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String leftString = s.substring(0, i);
			String rightString = s.substring(i + 1);
			String newString = leftString + rightString;

			printPermutation_V1(newString, ans + c);

		}

	}

}
