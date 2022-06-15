package com.kp.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaComparator {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		list.add(15);
		list.add(20);
		list.add(5);
		list.add(7);
		list.add(11);
		list.add(28);
		System.out.println(list);

		Comparator<Integer> c = (a, b) -> (a < b) ? -1 : (a > b) ? 1 : 0;

		Collections.sort(list, c);

		System.out.println(list);

	}

}
