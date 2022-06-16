package com.java8.features.lambda;
import java.util.*;
import java.util.function.*;

public class PredicateEvenNumber {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number : ");
		int a = sc.nextInt();
		
		// Chek if number is even or not
		
		Predicate<Integer> p = (x) -> x % 2 == 0;
		System.out.println(p.test(a));
		
		
		
		
		
	}

}
