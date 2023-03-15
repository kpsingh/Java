package com.java.streams;

import java.util.Arrays;
import java.util.List;

public class G_Resuce {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 7, 8, 23, 12, 3);

		// Sum of all number in the list - way 1
		Integer sum = list.stream().reduce(Integer::sum).get();
		System.out.println(sum);

		// Sum of all number in the list - way 2
		sum = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);

		sum = list.stream().reduce((a, b) -> a + b).get();
		System.out.println(sum);

		// Sum of all even number in the list
		sum = list.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).get();
		System.out.println(sum);

	}

}
