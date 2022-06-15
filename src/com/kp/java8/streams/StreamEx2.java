package com.kp.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx2 {

	public static void main(String[] args) {

		// this list can't be added/modifies as it is a fixed size list.
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println(list1);
		List<Integer> collect = list1.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println(collect);

	}

}
