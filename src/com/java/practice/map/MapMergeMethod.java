package com.java.practice.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://dzone.com/articles/one-method-to-rule-them-all-mapmerge
 *
 */
public class MapMergeMethod {

	public static void main(String[] args) {

		List<String> names = List.of("Krishna", "Rohit", "Aman", "Prakhar", "Ishika", "Rohit", "Aman");

		Map<String, Integer> map = new HashMap<>();

		// old ways
		for (String s : names) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}

		//map.entrySet().stream().forEach(e -> System.out.println(e));
		System.out.println("**********");

		/**
		 * java 8 ways
		 * 
		 * overwrite old value by simply returning the new one:
		 * 
		 * (old, new) -> new -- keep the new
		 * 
		 * (old, new) -> old -- keep the old
		 * 
		 * (old, new) -> old + new -- add both values (this is what we done in below)
		 * 
		 * (old, new) -> null -- if already exist then remove old value
		 */

		Map<String, Integer> map2 = new HashMap<>();

		names.forEach(x -> map2.merge(x, 1, (v1, v2) -> v1 + v2));

		map2.entrySet().stream().forEach(e -> System.out.println(e));

	}

}