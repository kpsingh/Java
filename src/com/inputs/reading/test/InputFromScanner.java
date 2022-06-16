package com.inputs.reading.test;
import java.util.Scanner;

/**
 * @author kpsin
 *
 */

public class InputFromScanner {

	public static void main(String args[]) {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the value of x ");
			int x = sc.nextInt();
			System.out.println("Entered value of x is " + x);
		}
		
	}
