package com.java.hackerrank;

public class RepeatingString {

	static long count = 0;

	public static void main(String[] args) {
		String s = "abcac";
		long n = 10;

		System.out.println(repeatedString(s, n));

	}

	public static long repeatedString(String s, long n) {

		if (s.length() > n) {
			count = count(s, n);
		} else {

			long initialCount = count(s, s.length());

			long multiple = (n / s.length());

			initialCount = initialCount * multiple;

			long remainder = n % s.length();

			if (remainder > 0) {
				count = initialCount + count(s, remainder);
			} else {
				count = initialCount;
			}

		}
		return count;

	}

	private static int count(String s, long n) {
		int localCount = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'a') {
				localCount++;
			}
		}
		return localCount;
	}

}
