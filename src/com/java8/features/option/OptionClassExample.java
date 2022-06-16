package com.java8.features.option;

import java.util.*;
import java.util.stream.Collectors;

public class OptionClassExample {

	/*
	 * recommended to use OPtional as return type to method who may return a null
	 * value.
	 */
	public static Optional<String> getName() {

		String name = null;
		return Optional.ofNullable(name);

	}

	public static void main(String args[]) {

		Optional<String> name = getName();
		if (name.isPresent()) {
			System.out.println("Welcome " + name.get());
		} else {
			System.out.println("No value returned from getName method");
		}

	}

}
