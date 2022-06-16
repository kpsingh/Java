package com.java8.features.lambda;

import java.util.function.*;
import java.util.*;

public class ConsumerTest {

	public static void main(String args[]) {

		// Consume the object
		
		Consumer<Person> c = p -> System.out.println(p.name + " : " + p.age);

		Person p1 = new Person("Krishna", 32);
		Person p2 = new Person("Ram", 12);
		Person p3 = new Person("Prasoon", 20);
		Person p4 = new Person("Ishita", 50);
		Person p5 = new Person("Radhika", 43);

		// Print only those person whose age is > 30
		
		Predicate<Person> pr = t -> t.age > 30;

		List<Person> lst = new ArrayList<>();
		lst.add(p1);
		lst.add(p2);
		lst.add(p3);
		lst.add(p4);
		lst.add(p5);

		for (Person p : lst) {
			if (pr.test(p)) {
				c.accept(p);
			}
		}

	}

}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

}