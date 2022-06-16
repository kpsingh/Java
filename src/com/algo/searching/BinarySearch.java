package com.algo.searching;


public class BinarySearch {
	
	public static void main(String[] args) {
	
	  int[] arr = {1,2,3,4,5,6,7,8};
	  
	  int result = searchIndex(arr, 5);
	  
	  System.out.println(result);
		
	
	}
	
	/*
	 * Method will take the an array and a search key as arguments.
	 */
	private static int searchIndex(int[] arr, int key) {
		
		int low = 0;
		int high = arr.length - 1;
		
		while (low <= high) {
			
			int mid = (int) Math.floor((low + high) / 2);
			
			if (arr[mid] == key) {
				return mid;
			}
			else if (arr[mid] < key) {
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		
		return -1;
	}
	

}
