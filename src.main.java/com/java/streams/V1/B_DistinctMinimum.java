package com.java.streams.V1;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://www.youtube.com/watch?v=N3gQdIn90CI&list=PLhfHPmPYPPRmwlUqOv4eDhMOF6IUXCWDJ&index=1
 */
public class B_DistinctMinimum {
	public static void main(String[] args) {
		
		

		int[] arr = { 4, 7, 0, 13, 90, 16, 2, 10, 0 };

		/*
		 * find the 3 distinct minimum from the arrays.
		 * 
		 */

		/**
		 * Old ways
		 */

		int[] copy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(copy);

		for (int i = 0; i < 3; i++) {
			/*
			 * In fact in case of duplicate it not work; need to work extra, it print 0, 0,
			 * 2 but it should print 0,2,4
			 */
			//System.out.println(copy[i]); //
		}

		/**
		 * java 8 ways
		 */

		IntStream.of(arr).distinct().sorted().limit(3).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		
	//	IntStream.of(arr).distinct().sorted().limit(3).forEach(System.out::println);

	}
	
	

}
