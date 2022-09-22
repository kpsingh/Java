package com.java.streams;

import java.util.Arrays;
import java.util.List;

public class EmpUtils {

	public static List<Employee> getEmployeeList() {

		return Arrays.asList(new Employee("Sumit", 25, 26000, "Pune", "Maharashtra"),
				new Employee("Mohan", 20, 23000, "Bhopal", "Madhya Pradesh"),
				new Employee("Naina", 26, 25000, "Delhi", "Delhi"),
				new Employee("Sachin", 35, 28000, "Kolkata", "West Bengal"),
				new Employee("Rahul", 45, 33300, "Bangalore", "Karnatka"),
				new Employee("Aman", 45, 33300, "Bangalore", "Karnatka"),
				new Employee("Saurav", 60, 45000, "Kochhi", "Kerala"),
				new Employee("Nidhi", 48, 38000, "Pathankot", "Himachal Pradesh"),
				new Employee("Pooja", 29, 88000, "Lucknow", "Uttar Pradesh"),
				new Employee("Ishika", 60, 5000, "Bhopal", "Gujrat"));
	}

}

class Employee {
	private String name;
	private int age;
	private int salary;
	private String city;
	private String state;

	Employee(String name, int age, int salary, String city, String state) {

		this.name = name;
		this.age = age;
		this.salary = salary;
		this.city = city;
		this.state = state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setCity(String city) {

		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public int getSalary() {
		return this.salary;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + "]";
	}
}
