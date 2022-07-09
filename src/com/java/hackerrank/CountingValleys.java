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

class Result1 {

	/*
	 * Complete the 'countingValleys' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER steps 2. STRING path
	 */

	static int valleys = 0;

	public static int countingValleys(int steps, String path) {
		// Write your code here

		Stack<Character> stack = new Stack<>();

		char[] chArr = path.toCharArray();

		for (char c : chArr) {
			
			if (stack.size() != 0) {
				
				if (c == stack.peek()) {
					stack.push(c);
				} else {
					stack.pop();
				}

			} else {
				if (c == 'D') {
					
					valleys++;
					stack.push(c);
					
				} else {
					stack.push(c);
				}
			}
		}

		return valleys;
	}

}

public class CountingValleys {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int steps = Integer.parseInt(bufferedReader.readLine().trim());

		String path = bufferedReader.readLine();

		int result = Result1.countingValleys(steps, path);

		System.out.print(result);

		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
