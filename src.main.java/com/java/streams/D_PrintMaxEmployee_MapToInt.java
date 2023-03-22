package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 
 * you can easily do this without sorting.. using mapToInt() and max()
 * functions. Sorting is not the right way to find answers to such questions...
 * Max, Min etc type aggregate functions are the right options.
 */

public class D_PrintMaxEmployee_MapToInt {

	public static void main(String[] args) {

		List<Employee> empList = getEmployeeList();

		// 5th Ways - IMP - Best Way
		System.out.println(empList.stream().mapToInt(e -> e.getSalary()).max().getAsInt());

		// 6th Way - IMP - Best Way
		System.out.println(empList.stream().mapToInt(Employee::getSalary).max().getAsInt());

		/**
		 * Print the employee based on highest salary to lowest salary - way 1
		 */

		System.out.println("\nPrint the employee based on highest salary to lowest salary : way 1\n");
		empList.stream().sorted((e1, e2) -> e2.getSalary() - e1.getSalary()).forEach(System.out::println);

		/**
		 * Print the employee based on highest salary to lowest salary - way 2
		 */

		System.out.println("\nPrint the employee based on highest salary to lowest salary : way 2\n");

		empList.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).forEach(System.out::println);

		/**
		 * Print the employee details with third highest salary
		 */

		System.out.println("\nPrint the employee details with third highest salary");
		empList.stream().sorted((e1, e2) -> e2.getSalary() - e1.getSalary()).skip(2).limit(1)
				.forEach(System.out::println);
		System.out.println("\n");

		/**
		 * Print the employee based on salary natural order
		 */

		System.out.println("\nPrint the employee based salary to lowest salary natural order");
		empList.stream().sorted((e1, e2) -> e1.getSalary() - e2.getSalary()).forEach(System.out::println);

		/**
		 * Print the employee based on salary natural order - Way 2
		 */

		System.out.println("\nPrint the employee based on salary natural order - Way 2");
		empList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).forEach(System.out::println);

		/**
		 * let suppose we had array instead of (list, set, map) of those object then how
		 * would you have done it ? array can be either primitive or custom array
		 */

		Employee[] arr = { new Employee("Sumit", 25, 26000, "Pune", "Maharashtra"),
				new Employee("Mohan", 20, 23000, "Bhopal", "Madhya Pradesh"),
				new Employee("Naina", 26, 25000, "Delhi", "Delhi"),
				new Employee("Sachin", 35, 28000, "Kolkata", "West Bengal"),
				new Employee("Rahul", 45, 33300, "Bangalore", "Karnatka"),
				new Employee("Saurav", 60, 45000, "Kochhi", "Kerala"),
				new Employee("Nidhi", 48, 38000, "Pathankot", "Himachal Pradesh"),
				new Employee("Pooja", 29, 88000, "Lucknow", "Uttar Pradesh"),
				new Employee("Saurav", 60, 10000, "Kochhi", "Kerala") };

		// 1st way
		System.out.println(Arrays.stream(arr).mapToInt(e -> e.getSalary()).max().getAsInt());

		// 2nd way : Internally Stream.of calls Arrays.stream();
		System.out.println(Stream.of(arr).mapToInt(Employee::getSalary).max().getAsInt());

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
				new Employee("Saurav", 60, 10000, "Kochhi", "Kerala"));
	}

}
