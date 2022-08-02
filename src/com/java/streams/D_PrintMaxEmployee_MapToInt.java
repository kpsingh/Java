package com.java.streams;

import java.util.ArrayList;
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

		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee("Rohit", 60));
		empList.add(new Employee("Krishna", 10));
		empList.add(new Employee("Prakhar", 15));
		empList.add(new Employee("Ronak", 56));
		empList.add(new Employee("Walter", 45));

		// 1st Way - bad way
		System.out.println(empList.stream().map(e -> e.getSal()).sorted(Comparator.reverseOrder()).findFirst().get());

		// 2nd Way
		System.out.println(empList.stream().map(e -> e.getSal()).min(Comparator.reverseOrder()).get());

		// 3rd way - IMP -
		System.out.println(empList.stream().map(e -> e.getSal()).max(Comparator.naturalOrder()).get());

		// 4th Way
		System.out.println(empList.stream().map(e -> e.getSal()).max((e1, e2) -> e1 - e2).get());

		// 5th Ways - IMP - Best Way
		System.out.println(empList.stream().mapToInt(e -> e.getSal()).max().getAsInt());

		// 6th Way - IMP - Best Way
		System.out.println(empList.stream().mapToInt(Employee::getSal).max().getAsInt());

		/**
		 * let suppose we had array instead of (list, set, map) of those object then how
		 * would you have done it ? array can be either primitive or custom array
		 */

		Employee[] arr = { new Employee("Rohit", 45), new Employee("Krishna", 56), new Employee("Prakhar", 70),
				new Employee("Ronak", 86), new Employee("Walter", 45) };

		// 1st way
		System.out.println(Arrays.stream(arr).mapToInt(e -> e.getSal()).max().getAsInt());

		// 2nd way : Internally Stream.of calls Arrays.stream();
		System.out.println(Stream.of(arr).mapToInt(Employee::getSal).max().getAsInt());

		// 3trd way - not good way... lot of extra work get done
		System.out.println(Arrays.asList(arr).stream().mapToInt(Employee::getSal).max().getAsInt());

	}

}

class Employee {
	private String name;
	private int sal;

	public Employee(String name, int sal) {
		super();
		this.name = name;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

}