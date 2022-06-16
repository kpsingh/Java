package com.kp.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx3 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println(list);

		Integer min = list.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		
		System.out.println(min);

	}

}
