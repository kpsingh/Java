package com.java.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * This class will have the example of finding the second, third.... min / max.
 * We also call this slicing the stream
 *
 * basically by using the skip and top method of streams we can achieve it.
 * 
 * https://www.youtube.com/watch?v=b4Atxh-a97M&list=PLyHJZXNdCXsfcMboYwGoL6wKAFPxljz5W&index=2
 *
 */

public class FindSecondMinMax {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 5, 4, 3, 12, 12, 13, 14, 15);

		// 1. Get the max element and min element

		int max = list.stream().distinct().mapToInt(i -> i).max().getAsInt();
		int min = list.stream().distinct().mapToInt(i -> i).min().getAsInt();

		System.out.println("Max : " + max + ", Min : " + min);

		// Get the min, second min, 3rd min ... etc

		Integer firstMin = list.stream().distinct().sorted().findFirst().get(); // get the top min
		List<Integer> minLists = list.stream().distinct().skip(1).limit(2).collect(Collectors.toList());

		System.out.println(firstMin);
		System.out.println("Second and Third min " + minLists);

		// Get the max, second max, 3rd max...etc

		List<Integer> maxLists = list.stream().distinct().sorted(Collections.reverseOrder()).skip(1).limit(3)
				.collect(Collectors.toList()); // get the top 3 excluding 1st max

		System.out.println(maxLists);

	}

}