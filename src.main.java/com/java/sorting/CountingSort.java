package com.java.sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class CountingSort {
	
	public static void main(String[] args) {
		
		
		SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		for(Entry<Integer, Integer> e : map.entrySet()) {
			for(int i = 1; i <= e.getValue(); i++) {
				result.add(e.getKey());
			}
		}
	}

}
