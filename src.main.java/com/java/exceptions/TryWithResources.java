package com.java.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * 
 * https://www.youtube.com/watch?v=9rS9X8WZElA
 * 
 * https://www.youtube.com/watch?v=MUYs1dR6lj8&list=PPSV
 * 
 * 
 * Before this concepts if we open any resource like I/O, DB or any other then
 * we have to close them in finally.
 * 
 * Its was programmers responsibility that he has to close the all resources. IT
 * basically increases programmers complexity because he has to make sure
 * closing all resource and if he missed then those resource get wasted.
 * 
 * Since java 1.7 they have introduced this and now JVM is responsible for
 * closing the resources.
 * 
 * 1. We can pass multiple resources, (;) as delimiter to try block and it will
 * take care for all.
 * 
 * 2. All resource passes are implicitly final that mean we can't re-assign them
 * with other resource in try block again.
 * 
 * 3. All resources should be AutoCloseable resource that mean they must
 * implement AutoCloseable interface.
 * 
 * An AutoCloseable object is called automatically when exiting a
 * try-with-resources block for which the object has been declared in the
 * resource specification header. This construction ensures prompt release,
 * avoiding resource exhaustion exceptions and errors that may otherwise occur
 * 
 * 4.In try with resources try(R1;R2)... we don't have to use catch or finally
 * mandatory. Only Try can also work.
 *
 */
public class TryWithResources {

	public static void main(String[] args) throws Exception {

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

		try (br1; br2) {

			System.out.println("Hello  : Try with resources");

		} catch (Exception e) {
		}

		try (FileReader fr = new FileReader("input.txt")) {

			// try without catch/finally also valid for since 1.7 for try with resource
			// option

		}

	}

}
