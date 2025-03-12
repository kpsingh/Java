package com.java.streams.V1;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * 
 */

public class AverageSalary_1491 {
	public static void main(String[] args) {
		int[] arr = {4000,3000,1000,2000};
		double ans = average(arr);
		System.out.println(ans);
		
	}
	
	  public static double average(int[] salary) {
		  
		 int n = salary.length;
		  
		 return IntStream.of(salary).sorted().skip(1).limit(n-2).average().getAsDouble();
	        
	    }

}
