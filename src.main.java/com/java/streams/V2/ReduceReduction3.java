package com.java.streams.V2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReduceReduction3 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, -2, 3, 1, 2);
		int k = 3;

		// list =
		// list.stream().sorted(Collections.reverseOrder()).limit(k).collect(Collectors.toList());

		int result = list.stream().sorted(Collections.reverseOrder()).limit(k).reduce((a, b) -> a + b).get();
		System.out.println(result);

	}

}


