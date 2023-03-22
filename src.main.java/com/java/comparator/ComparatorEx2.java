package com.java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorEx2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> list = new ArrayList<>();

		list.add(new Person("Krishna", 32));
		list.add(new Person("Rohit", 25));
		list.add(new Person("Aman", 17));
		list.add(new Person("Abhinav", 35));
		list.add(new Person("Gaurav", 35));

		/**
		 * if the data type is primitive then use this otherwise use the comapreTo for
		 * them
		 */

		/*
		 * Collections.sort(list, (p1, p2) -> { return p1.getAge() > p2.getAge() ? 1 :
		 * (p1.getAge() < p2.getAge() ? -1 : 0); });
		 */

		Collections.sort(list, (p1, p2) -> p2.getName().compareTo(p1.getName()));

		for (Person p : list) {
			System.out.println(p);
		}

		// other way to sort is by stream

		System.out.println("Sort by Stream API");

		// list.stream().sorted((p1, p2) ->
		// p1.getAge().compareTo(p2.getAge())).forEach(p -> System.out.println(p));

		list.stream().filter(s -> s.getName().startsWith("A")).sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.forEach(p -> System.out.println(p));

		System.out.println("Getting Min Age");

		Person minAge = list.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();

		System.out.println(minAge);

	}

}
