package com.inputs.reading.test;

import java.util.Scanner;

/*
 * 92X987-32 A","E","I","O","U","Y"
 * 
 * 0-1 3-4 4-5 7-8
 * 
 * and 3rd letter : is valid if the sum of every two consecutive digits of it is
 * even and its letter is not a vowel.is not vowels
 */

public class MixInput {

	public static boolean isValid = true;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String tag = sc.next();
		sc.close();

		if (tag.charAt(2) == ('A') | tag.charAt(2) == ('E') | tag.charAt(2) == ('I') | tag.charAt(2) == ('O')
				| tag.charAt(2) == ('U') | tag.charAt(2) == ('Y')) {

			isValid = false;

		}

		int a = Character.getNumericValue(tag.charAt(0));
		int b = Character.getNumericValue(tag.charAt(1));
		int c = Character.getNumericValue(tag.charAt(3));
		int d = Character.getNumericValue(tag.charAt(4));
		int e = Character.getNumericValue(tag.charAt(5));
		int f = Character.getNumericValue(tag.charAt(7));
		int g = Character.getNumericValue(tag.charAt(8));

		isEven(a, b);
		isEven(c, d);
		isEven(d, e);
		isEven(f, g);

		if (isValid) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
		}
	}

	private static void isEven(int a, int b) {
		if ((a + b) % 2 == 0) {
		} else {
			isValid = false;

		}

	}
}
