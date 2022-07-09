package com.java.practice.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapSort {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

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
		 * ##### Method 1 : Traditional #######
		 * 
		 * This is one way to sort the map. We can use the Collections.sort method which
		 * take list as the argument to sort.. hence we'll create the list of entry set
		 * and then sort based on the key or value
		 * 
		 * 1. Create the list of Entry (map internally used Entry as its object.) 2. Use
		 * the collections.sort(list, comparator) method to sort. 3. Pass the list we
		 * got in step-1 and use the labda expression for the comparator. 4. Use the key
		 * or value as per your need to compare.
		 */

		List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

		Collections.sort(entryList, (k1, k2) -> k1.getValue().compareTo(k2.getValue()));

		for (Entry<String, Integer> e : entryList) {
			/*
			 * IMP :- this will print - sort by value and if two values are equal then sort
			 * by key.
			 */
			System.out.println(e.getKey() + " : " + e.getValue());

		}

	}

}
