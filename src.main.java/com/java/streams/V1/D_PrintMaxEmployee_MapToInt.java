package com.java.streams.V1;

import java.util.Comparator;
import java.util.List;

/**
 * 
 * you can easily do this without sorting.. using mapToInt() and max()
 * functions. Sorting is not the right way to find answers to such questions...
 * Max, Min etc type aggregate functions are the right options.
 */

public class D_PrintMaxEmployee_MapToInt {

	public static void main(String[] args) {

		List<Employee> empList = EmpUtils.getEmployeeList();

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
		 * Print the employee based on NAMES
		 */

		System.out.println("\nPrint the employee based on NAMES : Sorted : \n");

		empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

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

	}

}
