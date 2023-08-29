package com.java.doc;

import java.util.ArrayList;
import java.util.List;

public class JavaDocStudy {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(2);
		System.out.println(list);
		
		Integer[] arr = new Integer[1];
		arr = list.toArray(arr);
		for(int a : arr) {
			System.out.println(a);
		}
		
	}

}
