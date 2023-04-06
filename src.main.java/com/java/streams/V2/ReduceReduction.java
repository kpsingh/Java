package com.java.streams.V2;

import java.util.*;

public class ReduceReduction {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		int sum = list.stream().reduce(0, (a, b) -> a + b);

		System.out.println("Total Sum : " + sum);

		Optional<Integer> reduce = list.stream().reduce(Integer::max);

		System.out.println("Total Max : " + reduce.get());

	}

}
