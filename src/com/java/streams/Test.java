package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		// Find the average of the square of given numbers
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		double avg = list.stream().mapToInt(i -> i * i).average().getAsDouble();

		System.out.println(avg);

		// Find the odd and even number from the list

		list.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));

		System.out.println();
		list.stream().filter(i -> i % 2 != 0).forEach(i -> System.out.print(i + " "));

		// Number or String Start with

		list = Arrays.asList(1, 22, 23, 24, 235, 65, 766, 83322, 922);

		System.out.println("\nNumber or String Start with");
		list.stream().map(e -> String.valueOf(e)).filter(s -> s.startsWith("2")).forEach(System.out::println);
		
		
		list.stream().map(i -> String.valueOf(i)).filter(s -> s.startsWith("2")).
		map(Integer::parseInt).collect(Collectors.toList());
		
		
		
		
		

	}

}
