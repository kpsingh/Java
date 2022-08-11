package com.java.practice.string;

import java.util.Iterator;

import org.w3c.dom.ls.LSOutput;

public class PalindromString {

	public static void main(String[] args) {

		String str = "abcba";

		System.out.println(isPalindrom_V1(str));
		System.out.println(isPalindrom_V2(str));
		System.out.println(isPalindrom_V3(str));

	}

	/**
	 * We'll reverse the original string and check if the original and reversed one
	 * are same or not.
	 * 
	 * If they are same that mean they are palindrom and if not same then not
	 * palindrom
	 * 
	 */
	public static boolean isPalindrom_V1(String s) {

		StringBuilder sb = new StringBuilder(s);

		return s.equalsIgnoreCase(sb.reverse().toString());

	}

	/**
	 * We can do by checking the index of the numbers traversing from left and right
	 * and if any two index not matched then not palindrom otherwise keep doing
	 * until left and right pointers not equals
	 */

	public static boolean isPalindrom_V2(String s) {

		int l = 0;
		int r = s.length() - 1;

		while (l < r) {

			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}

			l++;
			r--;

		}

		if (l == r)
			return true;

		return false;

	}

	public static boolean isPalindrom_V3(String s) {

		if (s.isBlank() && s.length() == 1)
			return true;

		return isPali(s, 0, s.length() - 1);

	}

	/*
	 * This method is by recursion.
	 */

	private static boolean isPali(String s, int leftIndex, int rightIndex) {

		if (leftIndex >= rightIndex)
			return true;

		if (s.charAt(leftIndex) != s.charAt(rightIndex))
			return false;

		return isPali(s, ++leftIndex, --rightIndex);
	}

}
