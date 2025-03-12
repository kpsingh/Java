package com.java.streams.V1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

		List<Employee> employeeList = EmpUtils.getEmployeeList();

		/**
		 * Print the department name and number of employee in each department
		 * 
		 */

		System.out.println("Print the city name and number of employee in each city\n");

		Map<String, Long> cityEmpCount = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));

		cityEmpCount.entrySet().stream().forEach(System.out::println);

		/**
		 * Print the list of Employee based on city name
		 * 
		 * Key will be city name and value will be list of Employee object belong to
		 * that city
		 * 
		 */
		System.out.println("\n****** Print the LIST of Emp based on City Name ****** \n");

		// default :- groupingBy(key, HashMap::new, toList());

		Map<String, List<Employee>> empByCityList = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getCity, Collectors.toList()));

		empByCityList.entrySet().stream().forEach(System.out::println);

		System.out.println("\n****** Print the SET of Emp based on City Name  ****** \n");

		Map<String, Set<Employee>> empByCitySet = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getCity, Collectors.toSet()));

		empByCitySet.entrySet().stream().forEach(System.out::println);

		/**
		 * above printed city names are not in sorted order... We want grouping to be
		 * ordered based on city name
		 * 
		 * Since by default grouping use HashMap.. explicitly tell it to use the TreeMap
		 * instead of HashMap.. and TreeMap by default maintains the sorting order to
		 * key
		 */

		System.out.println("\n****** Print the SET of Emp based on city Name - Sorted (used TreeMap)  ****** \n");

		// default :- groupingBy(key, HashMap::new, toList());

		Map<String, Set<Employee>> empByCitySorted = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getCity, TreeMap::new, Collectors.toSet()));

		empByCitySorted.entrySet().stream().forEach(System.out::println);

		/**
		 * In above the key's are sorted values are not sorted. Now make sure to print
		 * the values in sorted order too.
		 * 
		 * basically, key sorted and values are sorted too.... collect the result in
		 * TreeSet instead of HashSet
		 */

		System.out.println(
				"\n****** Print the SET of Emp based on city name - Sorted (used TreeMap) and Value sortef too (used TreeSet) ****** \n");

		TreeMap<String, TreeSet<Employee>> nameByCitySorted = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getCity, TreeMap::new,
						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName)))));

		nameByCitySorted.entrySet().stream().forEach(System.out::println);

		System.out.println("**********");

		employeeList.stream().collect(Collectors.groupingBy(Employee::getCity, TreeMap::new,
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName)))));
	}

}
