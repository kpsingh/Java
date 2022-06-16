package com.inputs.reading.test;
import java.util.Scanner;

public class ScannerArray {

	public static void main(String args[]) {
		
		int arr[] = new int[5];
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for (int i = 0; i < (arr.length); i++) {
			System.out.println("Please enter the " + (i+1) + " values to add into array");
			arr[i] = sc.nextInt();
		}
		
		for (int a : arr) {
			sum = sum + a;
		}
		
		sc.close();
		System.out.println("The sum of : " + sum);
		
	}
	
}
