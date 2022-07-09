package com.java.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test2 {

	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);

		int Q = 7;
		int[] type = { 1, 1, 1, 2, 1, 3, 3 };
		int[] X = { 5, 5, 11, 5, 16, 7, 11 };

		long[] out_ = solve(Q, type, X);
		System.out.print(out_[0]);
		for (int i_out_ = 1; i_out_ < out_.length; i_out_++) {
			System.out.print(" " + out_[i_out_]);
		}
		System.out.println();

		wr.close();
		br.close();
	}

	static long[] solve(int Q, int[] type, int[] X) {
		/*
		 * Q: Number of queries type: array denoting the type of each query X: array
		 * denoting parameter of each query
		 * 
		 */

		int j = 0;

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < Q; i++) {
			if (type[i] == 1) {
				add(map, X[i]);
			} else if (type[i] == 2) {
				remove(map, X[i]);
			} else {
				list.add(doXOR(map, X[i]));
				sum = 0;
			}

		}

		long[] result = new long[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	private static void add(Map<Integer, Integer> map, int key) {

		if (map.get(key) != null) {

			map.put(key, map.get(key) + 1);

		} else {
			map.put(key, 1);
		}

	}

	private static int doXOR(Map<Integer, Integer> map, int key) {

		map.forEach((k, v) -> {

			if (map.get(k) > 1) {
				sum = sum + (k ^ key) * map.get(k);
			} else {
				sum = sum + (k ^ key);
			}

		});

		return sum;

	}

	private static void remove(Map<Integer, Integer> map, int key) {

		
		Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();

		
		while (iterator.hasNext()) {

			
			Entry<Integer, Integer> entry = iterator.next();

			
			if (key == entry.getKey()) {

				
				iterator.remove();
			}
		}

	}
}
