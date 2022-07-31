package com.java.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionEx5 {

	public static void main(String[] args) {

		// String[] arr = { "Krishna", "Hello", "This", "He" };

		List<String> list = Arrays.asList("Krishna", "Hello", "This", "He");

		Function<String, Integer> f = s -> s.length();

		Map<String, Integer> map = new HashMap<>();

		list.forEach(i -> map.put(i, f.apply(i)));

		map.forEach((k, v) -> System.out.println(" Key : Value = " + k + " : " + v));

	}

}
