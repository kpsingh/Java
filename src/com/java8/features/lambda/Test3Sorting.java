package com.java8.features.lambda;
import java.util.*;

public class Test3Sorting {
	public static void main(String args[]) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(45);
		list.add(5);
		list.add(20);
		System.out.println(list);
		
		// Using Labda expression and ternary operator
		Comparator<Integer> c = (a,b) -> (a<b) ? -1 : (a>b)? 1 : 0;
		
		Collections.sort(list, c);
		System.out.println(list);
		
		
		
	}

}


