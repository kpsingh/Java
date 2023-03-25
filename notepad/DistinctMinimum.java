import java.util.*;
import java.util.stream.*;

public class DistinctMinimum {
	
	public static void main(String[] args){

		int[] arr = {1,6,2,6,7,7,3,3,9,8};


		/**
		 * Objective is to find the distinct minimum from the array
		 */

		IntStream.of(arr).distinct().sorted().limit(3).forEach(System.out::println);
	}
}