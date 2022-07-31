package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamEx5 {
	
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println(list);
		
		Consumer<Integer> c = i -> System.out.println(i * i);
		
		list.stream().forEach(c);

		
	}

}
