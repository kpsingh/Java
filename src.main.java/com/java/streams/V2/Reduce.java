package com.java.streams.V2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		BinaryOperator<Integer> op = (a, b) -> a + b;

		int reduction = reduce(list, 0, op);

		System.out.println(reduction);

		/*
		 * Simulations of parallel calculation.. lets assume we have two core(s)
		 * 
		 * This is how parallel stream works.. they divide the whole list/array into n
		 * parts and calculate the results for each parts independent of each other and
		 * the apply the same operation again on the result computed by each core
		 * 
		 */

		List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4); // core 1 computation
		List<Integer> list2 = Arrays.asList(5, 6, 7, 8, 9); // core 2 computation

		int reduction1 = reduce(list1, 0, op);
		int reduction2 = reduce(list2, 0, op);

		System.out.println(reduction1);
		System.out.println(reduction2);

		reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op); // merging of the computation from core 1 and
																			// core 2

		System.out.println(reduction);

	}

	private static int reduce(List<Integer> list, int valueIfEmpty, BinaryOperator<Integer> reduction) {

		int result = valueIfEmpty;

		for (int a : list) {
			result = reduction.apply(result, a);
		}

		return result;
	}
}
