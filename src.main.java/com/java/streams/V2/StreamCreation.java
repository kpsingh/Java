package com.java.streams.V2;

import java.util.stream.IntStream;

public class StreamCreation {

	public static void main(String[] args) {

		IntStream chars = "AZabc".chars();

		chars.forEach(System.out::println); 
	}

}
