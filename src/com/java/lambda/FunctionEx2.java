package com.java.lambda;

import java.util.function.Function;

public class FunctionEx2 {

	public static void main(String[] args) {

		String[] sa = { "Krishna", "KP", "Ramesh", "lara" };

		Function<String, Integer> f = s -> s.length();

		System.out.println(sa.toString());

		for (int i = 0; i < sa.length; i++) {

			System.out.print(f.apply(sa[i]));
			System.out.println();

		}

	}

}
