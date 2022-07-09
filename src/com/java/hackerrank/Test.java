package com.java.hackerrank;

import java.io.*;
import java.util.*;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[N][2];
			for (int i_arr = 0; i_arr < N; i_arr++) {
				String[] arr_arr = br.readLine().split(" ");
				for (int j_arr = 0; j_arr < arr_arr.length; j_arr++) {
					arr[i_arr][j_arr] = Integer.parseInt(arr_arr[j_arr]);
				}
			}

			long out_ = solve(N, arr);
			System.out.println(out_);

		}

		wr.close();
		br.close();
	}

	static long solve(int N, int[][] arr) {

		long result = 0;

		int maxX = Integer.MIN_VALUE;

		int index = -1;

		for (int i = 0; i < N; i++) {

			if (arr[i][0] > maxX) {
				maxX = arr[i][0];
				index = i;

			}

		}

		result = arr[index][0] * arr[index][1];

		int x_y = arr[index][1];

		for (int i = 0; i < N; i++) {

			if (x_y < arr[i][1]) {

				int diff = Math.abs(x_y - arr[i][1]);

				result = result + (arr[i][0] * diff);
			}

		}

		return result;
	}
}
