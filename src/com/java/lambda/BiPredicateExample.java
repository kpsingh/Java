package com.java.lambda;

import java.util.function.*;
import java.util.*;

public class BiPredicateExample {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter two numbers");

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		sc.close();

		// Predicate to check if sum of two numbers are even or not.

		BiPredicate<Integer, Integer> p = (a, b) -> (a + b) % 2 == 0;

		System.out.println(p.test(num1, num2));

	}

}
