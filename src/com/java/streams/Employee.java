package com.java.streams;

public class Employee {
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
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", city=" + city + ", state=" + state
				+ "]";
	}
}
