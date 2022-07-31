package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx1 {

	public static void main(String[] args) {

		// this list can't be added/modifies as it is a fixed size list.
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println(list1);

		boolean isEven = list1.stream().allMatch(i -> i % 2 == 0);

		List<Integer> collect = list1.stream().filter(i -> i > 2).collect(Collectors.toList());

		System.out.println(collect);

	}

}
