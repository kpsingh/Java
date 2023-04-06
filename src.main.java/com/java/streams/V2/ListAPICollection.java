package com.java.streams.V2;

import java.util.*;

public class ListAPICollection {

	public static void main(String[] args) {

		Person p1 = new Person("Krishna", 34);
		Person p2 = new Person("Sandhya", 26);
		Person p3 = new Person("Ishika", 24);
		Person p4 = new Person("Bandana", 55);
		Person p5 = new Person("Prateek", 30);

		List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

		list.removeIf(p -> p.getAge() > 30); // removeIf

		list.replaceAll(p -> new Person(p.getName().toUpperCase(), p.getAge()));// replaceAll

		list.sort(Comparator.comparing(p -> p.getAge())); // Comparator.comparing

		list.forEach(p -> System.out.println(p.getName()));

		System.out.println("***********");

		list.sort(Comparator.comparing(Person::getName));

		list.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName)); // Comparator.comparing(Person::getAge).thenComparing()

		list.forEach(p -> System.out.println(p.getName()));

		System.out.println("***********");

		list.sort(Comparator.comparing(Person::getName).reversed()); // Comparator.comparing(Person::getName).reversed()

		list.forEach(p -> System.out.println(p.getName()));

	}

}
