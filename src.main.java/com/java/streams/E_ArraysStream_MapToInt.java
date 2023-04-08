package com.java.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E_ArraysStream_MapToInt {

	public static void main(String[] args) {

		String intstr = "25 100 5 75";

		String str = "Hello man how are you";

		/**
		 * 
		 * Usually List, Set, Map - we can easily create stream from them but what about
		 * when we have arrays of primitive line int[], double[], float[] ????
		 * 
		 * 
		 * Then how to create stream for primitive array : in that case we can use the
		 * Arrays.stream() utility to create the stream and perform all the operation
		 * needed.
		 * 
		 * 
		 * This API will get the array of string and make the stream and then convert it
		 * into intStream and convert that into array.
		 * 
		 * 
		 * Arrays.stream() = Returns a sequential Stream with the specified array as its
		 * source.
		 */

		int[] array = Arrays.stream(intstr.split(" ")).mapToInt(Integer::parseInt).toArray(); // OR

		Arrays.stream(intstr.split(" ")).mapToInt(s -> Integer.parseInt(s)).forEach(System.out::println);

		/**
		 * Stream.of() = Returns a sequential ordered stream whose elements are the
		 * specified values.
		 * 
		 * Internally it calls Arrays.stream(values);
		 */
		System.out.println();
		Stream.of(intstr.split(" ")).mapToInt(Integer::parseInt).forEach(System.out::println);

		System.out.println();
		Stream.of(intstr.split(" ")).map(Integer::parseInt).sorted(Collections.reverseOrder())
				.forEach(System.out::println);

	}

}
