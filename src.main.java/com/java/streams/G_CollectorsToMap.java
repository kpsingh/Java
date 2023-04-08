package com.java.streams;

import java.util.Collections;
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

		List<Employee> employees = EmpUtils.getEmployeeList();

		/**
		 * Get the name of employee and their city
		 * 
		 */

		Map<String, String> empbyCity = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getCity));
		empbyCity.entrySet().forEach(System.out::println);

		/*
		 * If duplicate key found then it will throw the exception in that case we have
		 * to tell what to do when same key encountered again.
		 *
		 * 
		 * Key : City Name, Value : Name of Person,
		 * 
		 * If many people from the same city, have the latest/ old name
		 * 
		 * (oldValye, newValye) -> oldValye OR newValye ; that is if the same key came
		 * again replace its value by new key
		 * 
		 */

		System.out.println("\n**************\n");

		// if duplicate (e1, e2) -> e2 : keep the new employee name
		Map<String, String> cityAndEmp = employees.stream()
				.collect(Collectors.toMap(Employee::getCity, Employee::getName, (e1, e2) -> e2));

		cityAndEmp.entrySet().stream().forEach(System.out::println);

		/*
		 * Get the name of employee and their salary
		 * 
		 * have the name in sorted manner
		 * 
		 */

		System.out.println("\nEmployee and their salary : order by Emp Name\n");

		TreeMap<String, Integer> byISBNOrderByName = employees.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary, (e1, e2) -> e2, TreeMap::new));

		byISBNOrderByName.entrySet().stream().forEach(System.out::println);

		System.out.println("\n*** Alternate Way : Employee and their salary : order by Emp Name - Reverse Order ****\n");
		TreeMap<String, Integer> test = employees.stream().collect(
				Collectors.toMap(Employee::getName, Employee::getSalary, (e1, e2) -> e2, () -> new TreeMap<>(Collections.reverseOrder())));
		test.entrySet().stream().forEach(System.out::println);
	}

}
