package com.java.practice.string.knapsack;

public class ZeroOneKnapSackMemoization {

	static int[][] t = null;

	public static void main(String[] args) {

		int val[] = new int[] { 50, 75, 175, 110, 155 };
		int wt[] = new int[] { 50, 75, 175, 110, 155 };
		int w = 200; // max wait a vehicle can carry
		int n = val.length; // Number of items available to pick.

		t = new int[n + 1][w + 1];

		initializeMetrix(t, n, w);

		int maxProfit = knapSack(wt, val, w, n);
		System.out.println(maxProfit);

	}

	private static int knapSack(int[] wt, int[] val, int w, int n) {

		if (n == 0 || w == 0) {
			return 0;
		}

		if (t[n][w] != -1) {
			return t[n][w];
		}

		if (val[n - 1] <= w) {
			return t[n][w] = Math.max(val[n - 1] + knapSack(wt, val, w - val[n - 1], n - 1),
					knapSack(wt, val, w, n - 1));
		} else if (val[n - 1] > w) {
			return t[n][w] = knapSack(wt, val, w, n - 1);
		}

		return -1;

	}

	private static void initializeMetrix(int[][] t, int n, int w) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				t[i][j] = -1;
			}
		}

	}

}
