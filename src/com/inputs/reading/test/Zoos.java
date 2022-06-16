package com.inputs.reading.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Zoos {

	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		if (s.length() > 20) {
			return;
		}
		
		Map<Character, Integer> data = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			data.put(s.charAt(i), data.getOrDefault(s.charAt(i), 0) + 1);
		}

		int value1 = data.get('z');
		int value2 = data.get('o');
		
		if((value2 % value1) == 0 && (value2 / value1 > 1)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}	
		
	}
}
