package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 
 * In this example, we looked into the toMap() method of the Collectors class.
 * It allows us to create a new Map from a Stream.
 * 
 * We also learned how to resolve key conflicts and create different map
 * implementations.
 * 
 * https://www.baeldung.com/java-collectors-tomap
 * 
 * 
 * https://stackoverflow.com/questions/45231351/differences-between-collectors-tomap-and-collectors-groupingby-to-collect-in
 * 
 * https://stackoverflow.com/questions/21697349/using-streams-to-collect-into-treeset-with-custom-comparator
 * 
 * 
 * To collect into a Map that contains a single value by key
 * (Map<MyKey,MyObject>), use Collectors.toMap().
 * 
 * To collect into a Map that contains multiple values by key
 * (Map<MyKey,List<MyObject>>), use Collectors.groupingBy().
 * 
 */

public class G_CollectorsToMap {
	public static void main(String[] args) {

		List<Employee> employees = getEmployeeList();
		/**
		 * get the State and name of person
		 * 
		 * 
		 */

		employees.stream().collect(Collectors.toMap(e -> e.getState(), e -> e.getSalary())); // OR

		employees.stream().collect(Collectors.toMap(Employee::getState, Employee::getName)).entrySet()
				.forEach(System.out::println);

		/*
		 * Problem with this is if two keys are duplicate then it throw the issue. If we
		 * know keys are duplicate then we can use the overloaded method of toMap.
		 * 
		 * To resolve it, we need to use a different method with an additional
		 * parameter, the mergeFunction:
		 * 
		 * For Example if key is Year then possibility multiple books in same years.
		 * 
		 * 
		 * (oldValye, newValye) -> newValye ; that is if the same key came again replace
		 * its value by new key
		 */
		
		

		System.out.println();

		Map<String, Integer> bookMapByYear = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary, (e1, e2) -> e2));

		bookMapByYear.entrySet().stream().forEach(System.out::println);

		/*
		 * Let say we store into map by key as ISBN and value as name
		 * 
		 * Lastly, let's see how to return a sorted map. For that, we'll use a TreeMap
		 * as a mapSupplier parameter.
		 * 
		 * Because a TreeMap is sorted according to the natural ordering of its keys by
		 * default, we don't have to explicitly sort.
		 * 
		 * 
		 */

		System.out.println("\nOrder by Key (ISBN)\n");

		TreeMap<String, Integer> byISBNOrderByName = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary, (e1, e2) -> e2, TreeMap::new));

		byISBNOrderByName.entrySet().stream().forEach(System.out::println);

		System.out.println("\n*** Alternate Way for Above : Test Output ****\n");
		TreeMap<String, Integer> test = employees.stream().collect(
				Collectors.toMap(Employee::getName, Employee::getSalary, (e1, e2) -> e2, () -> new TreeMap<>()));
		test.entrySet().stream().forEach(System.out::println);
	}

	public static List<Employee> getEmployeeList() {

		return Arrays.asList(new Employee("Sumit", 25, 26000, "Pune", "Maharashtra"),
				new Employee("Mohan", 20, 23000, "Bhopal", "Madhya Pradesh"),
				new Employee("Naina", 26, 25000, "Delhi", "Delhi"),
				new Employee("Sachin", 35, 28000, "Kolkata", "West Bengal"),
				new Employee("Rahul", 45, 33300, "Bangalore", "Karnatka"),
				new Employee("Saurav", 60, 45000, "Kochhi", "Kerala"),
				new Employee("Nidhi", 48, 38000, "Pathankot", "Himachal Pradesh"),
				new Employee("Pooja", 29, 88000, "Lucknow", "Uttar Pradesh"),
				new Employee("Saurav", 60, 50, "Kochhi", "Gujrat"));
	}

}

