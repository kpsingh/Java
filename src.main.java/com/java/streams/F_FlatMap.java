package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * https://www.youtube.com/watch?v=CwvlS3ViGFQ
 *
 */

public class F_FlatMap {

	public static void main(String[] args) {

		List<Person> customerList = CustomerList.getCustomerList();

		List<Integer> ids = customerList.stream().map(e -> e.getId()).collect(Collectors.toList());

		System.out.println(ids);

		/*
		 * map will return the list of list.
		 * 
		 * Map :- One to One mapping
		 * 
		 */

		List<List<Integer>> collectPhone = customerList.stream().map(e -> e.getPhone()).collect(Collectors.toList());

		System.out.println(collectPhone);

		/*
		 * Flat Map will return the list
		 * 
		 * FlatMap :- One to MANY mapping : IT will combine all list of list into single
		 * list. Basically from 2D to 1D
		 * 
		 */

		List<Integer> flatPhone = customerList.stream().flatMap(e -> e.getPhone().stream())
				.collect(Collectors.toList());

		System.out.println(flatPhone);

	}

}

class Person {

	private int id;
	private String email;

	// one user can have many phone number
	private List<Integer> phone;

	public Person(int id, String email, List<Integer> phone) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Integer> getPhone() {
		return phone;
	}

	public void setPhone(List<Integer> phone) {
		this.phone = phone;
	}

}

class CustomerList {

	public static List<Person> getCustomerList() {

		return Stream.of(new Person(101, "Krishna", Arrays.asList(123, 456)),
				new Person(102, "Rohit", Arrays.asList(126, 456)), new Person(103, "Aman", Arrays.asList(455, 5555)),
				new Person(104, "Ish", Arrays.asList(888))

		).collect(Collectors.toList());

	}
}