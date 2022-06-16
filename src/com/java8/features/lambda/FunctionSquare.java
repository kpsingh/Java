package com.java8.features.lambda;
import java.util.function.*;

public class FunctionSquare {
	public static void main(String args[]) {
		
		// This function take the integer as an input and produce square of it and that is also integer
		Function<Integer, Integer> f = i -> i * i;
		
		int arr[] = {1,2,3,4,5};
		for (int a : arr) {
			System.out.println(a);
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = f.apply(arr[i]);
		}
		
		System.out.println("****************");
		
		for (int a : arr) {
			System.out.println(a);
		}
	}
	

}
