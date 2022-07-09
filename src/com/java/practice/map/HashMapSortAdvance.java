package com.java.practice.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapSortAdvance {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

	//	map.put("BALANCE", 312);
	//	map.put("RAM", 321);
	//	map.put("ZYZ", 123);
	//	map.put("KP", 123);
	//	map.put("ABC", 312);
	//	map.put("Anand", 321);

		map.put("Aohit", 111);
		map.put("Mohit", 112);
		map.put("Rahul", 111);
		map.put("Kohit", 125);
		map.put("Lohit", 112);
		map.put("Neha", 90);
		map.put("Meha", 87);
		map.put("Rhea", 12);
		map.put("Raghu", -2);
		map.put("Roshan", -10);
		
		/*
		 * sorted(Map.Entry.comparingByKey()) & sorted(Map.Entry.comparingByValue())
		 */

		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey())
		.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
		
		System.out.println("*********************");
		
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

	}

}
