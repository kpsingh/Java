package com.java.multithreading.V1;

import java.util.HashSet;
import java.util.Set;

public class Test {

	static Set<String> allSets = new HashSet<>();

	public static void main(String[] args) {

		String str = "abc";

		permute(str, "");

		System.out.println("All set possible form the string...." +  allSets.size());
		System.out.println(allSets);

	}

	private static void permute(String str, String ans) {

		allSets.add(str);

		if (str.isBlank()) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			String merString = left + right;

			permute(merString, ans + c);

		}

	}
}
