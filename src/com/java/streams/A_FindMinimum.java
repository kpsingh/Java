package com.java.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/*
 * https://www.youtube.com/watch?v=N3gQdIn90CI&list=PLhfHPmPYPPRmwlUqOv4eDhMOF6IUXCWDJ&index=1
 * 
 */

public class A_FindMinimum {

	public static void main(String[] args) {

		int[] arr = { -4, 7, 13, 90, 16, 2, 10 };

		/*
		 * finding the minimum in old ways
		 */

		int min = arr[0];

		for (int a : arr) {

			if (a < min) {
				min = a;
			}
		}

		System.out.println(min);

		/*
		 * finding the minimum using java 8 stream
		 * 
		 */

		System.out.println(IntStream.of(arr).min().getAsInt());

		IntStream.of(arr).min().ifPresent(x -> System.out.println(x));

		IntSummaryStatistics summaryStatistics = IntStream.of(arr).summaryStatistics();
		System.out.println(summaryStatistics.getMax());
		System.out.println(summaryStatistics.getAverage());
		System.out.println(summaryStatistics.getSum());
		System.out.println(summaryStatistics.getCount());
		System.out.println(summaryStatistics.getMin());

	}

}
