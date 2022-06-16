package com.java8.features.lambda;

public class Test2 {

	public static void main(String arr[]) {
		
		Sum s = (a,b) -> System.out.println("The sum is : " + (a+b));
		s.sum(5, 6);
		
		
		
	}
}

interface Sum {
	public void sum(int a, int b);
}