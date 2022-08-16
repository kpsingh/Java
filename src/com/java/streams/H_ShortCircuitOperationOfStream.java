package com.java.streams;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

/**
 * 
 * https://www.youtube.com/watch?v=ZnGToO5fL20&list=PLyHJZXNdCXsfcMboYwGoL6wKAFPxljz5W&index=10
 *
 */

public class H_ShortCircuitOperationOfStream {
	public static void main(String[] args) {

		List<String> list = Arrays.asList("Rohit", "Krishna", "Ishika", "Neha", "Sandhya", "Raman", "Neeraj");

		// findFirst is one of the short circuit operation

		String name = list.stream().filter(s -> s.contains("N")).findFirst().get();
		System.out.println(name);

		// orElse used to specify if no element met the filter criteria
		name = list.stream().filter(s -> s.contains("L")).findFirst().orElse("No name start with L");
		System.out.println(name);

		/**
		 * The findAny() method returns any element from a Stream, while the findFirst()
		 * method returns the first element in a Stream
		 * 
		 * findAny() : The behavior of this operation is explicitly nondeterministic; it
		 * is free to select any element in the stream. This is to allow for maximal
		 * performance in parallel operations;
		 * 
		 * https://stackoverflow.com/questions/35359112/difference-between-findany-and-findfirst-in-java-8
		 * 
		 * for PARALLEL stream they may behave DIFFERENT but for sequential stream
		 * findFirst() and findAny() behave SAME. IDEMPOTENT in nature.. that mean
		 * return the same result on every run
		 * 
		 */

		name = list.stream().filter(s -> s.contains("N")).findAny().get();
		System.out.println(name);// Always return Neha

		name = list.stream().parallel().filter(s -> s.contains("N")).findAny().get();
		System.out.println(name); // can return either Neha or Neeraj since stream is parallel()

		/**
		 * Stream.allMatch() : method returns true if all the elements of the stream
		 * match the provided predicate condition. If even one of the elements does not
		 * match the predicate condition then the method skips the testing of the
		 * remaining elements using the concept of short-circuit evaluation and returns
		 * false as the result. This is a terminal stream operation.
		 * 
		 * 
		 * Stream.anyMatch() : method returns true if at least 1 of the elements of the
		 * stream match the provided predicate condition.
		 * 
		 * 
		 * Stream.noneMatch() : method returns true if none of the elements of the
		 * stream match the provided predicate condition. If one (or more) of the
		 * elements match the predicate condition then the method returns false. The
		 * moment this method finds the first element satisfying the predicate, it skips
		 * the testing of the remaining elements using the concept of short-circuit
		 * evaluation and returns false as the result.
		 * 
		 */

		boolean isPresent = list.stream().anyMatch(s -> s.startsWith("A"));
		System.out.println(isPresent);// false as no name start with A

		isPresent = list.stream().noneMatch(s -> s.startsWith("A"));
		System.out.println(isPresent); // true as no name start with A

	}

}
