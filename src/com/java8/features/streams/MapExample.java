package com.java8.features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();

		lst.add(10);
		lst.add(5);
		lst.add(7);
		lst.add(14);
		lst.add(6);
		lst.add(8);
		lst.add(4);
		System.out.println(lst);

		// For each element square the element
		lst = lst.stream().map(i -> i * i).collect(Collectors.toList());

		System.out.println(lst);

	}

}

// Method reference
// forEach of java8