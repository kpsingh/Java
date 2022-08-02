package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C_StringNewMethods {

	public static void main(String[] args) {

		String s = "Baeldung helps \n \n developers \n explore Java.";

		s.lines().filter(line -> !line.isBlank()).map(x -> x.strip()).collect(Collectors.toList())
				.forEach(System.out::println);

		s.lines().filter(line -> !line.isBlank()).map(x -> x.strip()).forEach(System.out::print);

		// Collection to an Array

		List<String> list = Arrays.asList("Java", "Kotlin");

		String[] y = list.toArray(String[]::new);

		System.out.println("**********************");

		System.out.println("**********************");

		/*
		 * split a comma separated String into a list/ set / map of String using Stream
		 * API:
		 */

		String str = "Krishna helps developers to explore Java ";

		Set<String> collectSet = Stream.of(str.split(" ")).map(e -> new String(e)).collect(Collectors.toSet());

		List<String> collectList = Stream.of(str.split(" ")).map(e -> new String(e)).collect(Collectors.toList());

		Map<String, Integer> collectMap = Stream.of(str.split(" ")).sorted()
				.collect(Collectors.toMap(e -> e, e -> e.length()));

		collectMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

		System.out.println("*******************");
		
		
		
		

		
		
		
		

	}

}
