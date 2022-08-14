package com.java.practice.string.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class HashMapSortAdvance {

	public static void main(String[] args) {

		/*
		 * Use the Tree Map if we need to sort by Key and Value.
		 * 
		 * TreeMap will is s kind of sorted may by key and you only need to sort the map
		 * by values.
		 */
		TreeMap<String, Integer> map = new TreeMap<>();

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


		System.out.println("******* Sort by Value  ************");

		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

		System.out.println("Sort by Value Desc...");

		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
	}

}
