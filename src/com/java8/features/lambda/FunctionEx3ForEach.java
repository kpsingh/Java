package com.kp.java8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionEx3ForEach {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Function<Integer, Integer> f = i -> i * i;

		list.forEach(i -> System.out.println(f.apply(i)));

	}

}
