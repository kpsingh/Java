package com.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerEx1 {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };

		Function<Integer, Integer> f = i -> i * i;

		Consumer<Integer> c = i -> System.out.println(i);

		for (int i : arr) {
			c.accept(f.apply(i));
		}

	}
}
