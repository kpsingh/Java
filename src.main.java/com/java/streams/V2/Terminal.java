package com.java.streams.V2;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;

public class Terminal {

	public static void main(String[] args) {

		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> list = Arrays.asList(1, 2, 3,4);

		System.out.println(list.stream().count()); // count
		System.out.println(list.stream().reduce(0, (a, b) -> a + b)); // reduce
		System.out.println(list.stream().min((a, b) -> a - b)); // min
		System.out.println("Comparator.comparingInt : " + list.stream().max(Comparator.comparingInt(a -> a))); // max
		System.out.println(list.stream().mapToInt(a -> a).sum()); // mapToInt stream

		list.stream().skip(2).limit(3).forEach(System.out::println);

		// Match Reduce

		boolean result = list.stream().anyMatch(a -> a == 9); // anyMatch

		System.out.println("Is any elemetn equal to 9 : " + result);

		System.out.println("Does all elemetn less than 11 : " + list.stream().allMatch(a -> a < 11)); // allMatch

		System.out.println("Does non of element less than 1 : " + list.stream().noneMatch(a -> a < 1)); // noneMatch

		Stream<String> st = Stream.iterate("", (str) -> str + "x");
		st.limit(3).map(str -> str + "y").forEach(System.out::println);

	}

}
