import java.util.*;
import java.util.stream.*;

public class FindMin {

	public static void main(String[] args){

		int[] arr = {1,6,3,-2,7,9};
		

		/**
		 * Objective is to find the minimum from the given array
		 * 1. Old Way
		 * 2. Java8
		 */

		// Old way

		int  min = arr[0];

		for(int a : arr){

			min = a < min ? a : min;
		}

		System.out.println("Old Way : " + min);

		//System.out.println("Finding the minimum in java 8 way");

		int min2 = IntStream.of(arr).min().getAsInt();

		System.out.println("New Way : " + min2);



	}
}