package com.java.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * you can easily do this without sorting.. using mapToInt() and max()
 * functions. Sorting is not the right way to find answers to such questions...
 * Max, Min etc type aggregate functions are the right options.
 */

public class D_PrintMaxEmployee {

	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<>();

		empList.add(new Employee("Rohit", 60));
		empList.add(new Employee("Krishna", 10));
		empList.add(new Employee("Prakhar", 15));
		empList.add(new Employee("Ronak", 56));
		empList.add(new Employee("Walter", 45));

		// 1st Way
		System.out.println(empList.stream().map(e -> e.getSal()).sorted(Comparator.reverseOrder()).findFirst().get());

		// 2nd Way
		System.out.println(empList.stream().map(e -> e.getSal()).min(Comparator.reverseOrder()).get());

		// 3rd way - IMP
		System.out.println(empList.stream().map(e -> e.getSal()).max(Comparator.naturalOrder()).get());

		// 4th Way
		System.out.println(empList.stream().map(e -> e.getSal()).max((e1, e2) -> e1 - e2).get());

		// 5th Ways - IMP
		System.out.println(empList.stream().mapToInt(e -> e.getSal()).max().getAsInt());

		// 6th Way - IMP
		System.out.println(empList.stream().mapToInt(Employee::getSal).max().getAsInt());

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