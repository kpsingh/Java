package com.java.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E_ArraysStream_MapToInt {

	public static void main(String[] args) {

		String str = "25 100 5 75";

		String str1 = "Hello man how are you";

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

		Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.stream(str.split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();

		/**
		 * In a single line create map with string and its length
		 */

		Map<String, Integer> collect = Arrays.stream(str1.split(" ")).map(String::new)
				.collect(Collectors.toMap(e -> e, e -> e.length()));

		/**
		 * In a single line print its string and length
		 *
		 */

		Arrays.stream(str1.split(" ")).map(String::new).forEach(s -> System.out.println(s + " : " + s.length()));

		System.out.println("After the change");
		Arrays.stream(str1.split(" ")).map(s -> s).forEach(s -> System.out.print(s + " : " + s.length() + " ; "));

		/**
		 * Stream.of() = Returns a sequential ordered stream whose elements are the
		 * specified values.
		 * 
		 * Internally it calls Arrays.stream(values);
		 */
		System.out.println();
		Stream.of(str.split(" ")).mapToInt(Integer::parseInt).forEach(System.out::println);

	}

}
