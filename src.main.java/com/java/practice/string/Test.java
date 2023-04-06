package com.java.practice.string;

public class Test {

	public static void main(String[] args) {

		String s = "abc";
		String t = "bca";

		int[] arr = new int[26];

		arr[5]++;

		System.out.println('a' - 'a');
		System.out.println('b' - 'a'); 
		System.out.println('c' - 'a');
		System.out.println('a');

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}

		for (int a : arr) {
			if (a != 0) {
				System.out.println("False");
			}
		}
		System.out.println("True");
	}

}
