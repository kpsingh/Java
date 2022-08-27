package com.java.test.junit;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		
		int[] arr = {1,2,3,4,5};
		
		Arrays.asList(arr).stream().sorted(Comparator.comparingInt(null));
	}

}
