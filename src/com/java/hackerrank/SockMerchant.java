package com.java.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'sockMerchant' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. INTEGER_ARRAY ar
	 */

	static Integer result = 0;

	public static int sockMerchant(int n, List<Integer> ar) {
		// Write your code here

		Map<Integer, Integer> map = new HashMap<>();

		ar.stream().forEach(x -> {

			if (map.get(x) != null) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}

		});

		map.forEach((k, v) -> {

			if (map.get(k) >= 2) {
				result = result + (map.get(k) / 2);
			}

		});

		return result;

	}

}

public class SockMerchant {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = Result.sockMerchant(n, ar);

		System.out.println(result);

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
