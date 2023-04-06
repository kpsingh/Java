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
		
		System.out.println(map.get("paris")); // old way not much meaning full
		
		System.out.println(map.getOrDefault("paris", new ArrayList<>()));
		
		System.out.println(map.getOrDefault("paris", Collections.emptyList()));
		
		map.com
		
		
		

	}

}
