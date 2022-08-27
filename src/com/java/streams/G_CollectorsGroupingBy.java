package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
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
 * 
 */

public class G_CollectorsGroupingBy {

	public static void main(String[] args) {

		List<Emp> empList = Emp.getEmps();

		/**
		 * Print the department name and number of employee in each department
		 * 
		 */

		System.out.println("Print the department name and number of employee in each department\n");

		Map<String, Long> depEmpCount = empList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepID(), Collectors.counting()));

		depEmpCount.entrySet().stream().forEach(System.out::println);

		/**
		 * Print the list of Emp based on department ID
		 * 
		 * Key will be department Id and value will be list of Emp object belong to that
		 * department id
		 */
		System.out.println("\n****** Print the LIST of Emp based on department ID ****** \n");

		// default :- groupingBy(key, HashMap::new, toList());

		Map<String, List<Emp>> empByDepartList = empList.stream().collect(Collectors.groupingBy(emp -> emp.getDepID(),Collectors.toList()));

		empByDepartList.entrySet().stream().forEach(System.out::println);

		/**
		 * If the name of employee and department is same then duplicate value should
		 * not come like...
		 * 
		 * AI=[[108, Ankit, AI], [109, Ankit, AI]]
		 * 
		 * In that Case use the Set to store the value in map for each department ID.
		 * Explicitly telling grouping collector to use hashSet
		 * 
		 */

		System.out.println("\n****** Print the SET of Emp based on department ID ****** \n");

		Map<String, Set<Emp>> empByDepartset = empList.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepID(), Collectors.toSet()));

		empByDepartset.entrySet().stream().forEach(System.out::println);

		/**
		 * above printed department names are not in sorted order... We want grouping to
		 * be ordered based on department name
		 * 
		 * Since by default grouping use HashMap.. explicitly tell it to use the TreeMap
		 * instead of HashMap.. and TreeMap by default maintains the sorting order to
		 * key
		 */

		System.out.println("\n****** Print the SET of Emp based on department ID - Sorted (used TreeMap)  ****** \n");

		// default :- groupingBy(key, HashMap::new, toList());

		TreeMap<String, Set<Emp>> empByDepartsetTreemap = empList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepID(), TreeMap::new, Collectors.toSet()));

		empByDepartsetTreemap.entrySet().stream().forEach(System.out::println);

		/**
		 * In above the key's are sorted values are not sorted. Now make sure to print
		 * the values in sorted order too.
		 * 
		 * basically, key sorted and values are sorted too.... collect the result in
		 * TreeSet instead of HashSet
		 */

		System.out.println(
				"\n****** Print the SET of Emp based on department ID - Sorted (used TreeMap) and Value sortef too (used TreeSet) ****** \n");

		TreeMap<String, TreeSet<Emp>> depOrderkeyValues = empList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepID(), TreeMap::new,
						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Emp::getName)))));

		depOrderkeyValues.entrySet().stream().forEach(System.out::println);
		
		
		System.out.println("\n****** Alternate Way 1 ******");
		
		
		TreeMap<String, TreeSet<Emp>> test = empList.stream()
				.collect(Collectors.groupingBy(e -> e.getDepID(), TreeMap::new,
						Collectors.toCollection(() -> new TreeSet<>((e1, e2) -> e1.getName().compareTo(e2.getName())))));
		
		test.entrySet().stream().forEach(System.out::println);

	}

}

class Emp {

	int empID;
	String name;
	String depID;

	public Emp(int empID, String name, String depID) {
		super();
		this.empID = empID;
		this.name = name;
		this.depID = depID;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + empID + ", " + depID + "]";
	}

	public static List<Emp> getEmps() {

		return Arrays.asList(new Emp(101, "Aman", "CSE"), new Emp(102, "Gandhi", "CSE"), new Emp(103, "Ishika", "EC"),
				new Emp(104, "Rohit", "CE"), new Emp(105, "Vikash", "ME"), new Emp(106, "Rohit", "CSE"),
				new Emp(107, "Vikash", "EC"), new Emp(108, "Ankit", "AI"), new Emp(109, "Ankit", "AI"));

	}

	/*
	 * Important HashCode and Equals method so that Set/Map able to compare two Emp
	 * objects based on the attributes we want.
	 * 
	 * Let assume of Name and Department is same then we consider them equals.
	 */

	@Override
	public int hashCode() {
		return Objects.hash(depID, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return Objects.equals(depID, other.depID) && Objects.equals(name, other.name);
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepID() {
		return depID;
	}

	public void setDepID(String depID) {
		this.depID = depID;
	}

}
