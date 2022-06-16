package com.java8.features.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class FilterExample {

	public static void main(String args[]) throws IOException {

		List<Integer> lst = new ArrayList<>();

		lst.add(10);
		lst.add(5);
		lst.add(7);
		lst.add(14);
		lst.add(56);
		lst.add(87);
		lst.add(34);
		System.out.println(lst);

		lst = lst.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

		System.out.println(lst);

	}

}
