package com.java.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * 
 * https://www.youtube.com/watch?v=aaokKp87Hoc&list=PLyHJZXNdCXsfcMboYwGoL6wKAFPxljz5W&index=3
 */

public class FindTheDuplicateNumbers {

	public static void main(String[] args) {

		/**
		 * finding the duplicates by 1.8 Java - Stream API's
		 * 
		 * by using filter(i -> Collections.frequency(list, i) > 1)
		 * 
		 * 
		 */

		// Way 1 - by Collections.frequency
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 5, 4, 3, 12, 12, 13, 14, 15);

		System.out.println("Finding the duplicates by 1.8 Java - Stream API's");

		Set<Integer> dupCollect = list.stream().filter(i -> Collections.frequency(list, i) > 1)
				.collect(Collectors.toSet());

		System.out.println("WAY 1 -> " + dupCollect);

		// Way 2 - by HashSet

		HashSet<Integer> unique = new HashSet<>(); // this set will have all unique elements

		Set<Integer> duplicate = list.stream().filter(s -> !unique.add(s)).collect(Collectors.toSet());

		System.out.println("WAY 2 ->" + duplicate);

		/**
		 * Way 3 - by Collectors.groupingBy
		 * 
		 * This will return a map with element as key and its count as its value. If
		 * count > 1 that mean duplicate element.
		 * 
		 */

		Map<Integer, Long> dupMap = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		dupMap.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).forEach(System.out::println);

		// use streams and collect to get a list of duplicate numbers
		List<Integer> duplicates = list.stream().filter(n -> list.stream().filter(x -> x.equals(n)).count() > 1)
				.distinct().collect(Collectors.toList());

		// print out the list of duplicate numbers
		System.out.println("Duplicate numbers: " + duplicates);

		/**
		 * Alternatively
		 */

		// use stream API to filter out distinct elements and collect the duplicates
		duplicates = list.stream().filter(i -> list.indexOf(i) != list.lastIndexOf(i)).distinct()
				.collect(Collectors.toList());

		// print the duplicates
		System.out.println("Duplicates: " + duplicates);

	}
}
