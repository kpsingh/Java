package com.java.practice.knapsack;

public class ZeroOneKnapSackRecursive {

	// private static int maxProfit = 0;

	public static void main(String[] args) {

		int val[] = new int[] { 50, 75, 175, 110, 155 };
		int wt[] = new int[] { 50, 75, 175, 110, 155 };
		int capacity = 200; // max wait a vehicle can carry
		int n = val.length; // Number of items available to pick.

		int maxProfit = knapSack(wt, val, capacity, n);
		System.out.println(maxProfit);

	}

	private static int knapSack(int[] wt, int[] val, int capacity, int n) {

		/*
		 * if no items available to pick or if the bag has no capacity then profit will
		 * be Zero.
		 * 
		 */

		if (n == 0 || capacity == 0)
			return 0;

		
		
		if (wt[n - 1] < capacity) {
			return Math.max(val[n - 1] + knapSack(wt, val, capacity - val[n - 1], n - 1),
					knapSack(wt, val, capacity, n - 1));
		} else if (wt[n - 1] > capacity) {
			return knapSack(wt, val, capacity, n - 1);
		}
		return -1;
	}

}
