package com.java.streams.V2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAPICollections {

	public static void main(String[] args) {

		Person p1 = new Person("Krishna", 34);
		Person p2 = new Person("Sandhya", 26);
		Person p3 = new Person("Ishika", 24);
		Person p4 = new Person("Bandana", 55);
		Person p5 = new Person("Prateek", 30);

		City delhi = new City("Delhi");
		City paris = new City("Paris");
		City london = new City("London");

		Map<City, List<Person>> map = new HashMap<>();

		map.putIfAbsent(paris, new ArrayList<>()); // putIfAbsent : One way to populate map

		map.get(paris).add(p5);

		System.out.println(map.getOrDefault(paris, new ArrayList<>())); // getOrDefault

		// System.out.println(map.getOrDefault(paris, Collections.emptyList()));

		map.computeIfAbsent(london, key -> new ArrayList<>()).add(p3); // computeIfAbsent : A better way to do populate
																		// map

		System.out.println(map.getOrDefault(london, new ArrayList<>()));

		map.computeIfAbsent(delhi, key -> new ArrayList<>()).add(p1);
		System.out.println(map.getOrDefault(delhi, new ArrayList<>()));
		
		

	}

}
