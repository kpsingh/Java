package com.java8.features.lambda;
import java.util.function.*;
import java.util.*;

public class FunctionLengthOfString {
	
	public static void main(String args[]) {
		
		// Function will take string as an argument and return te length of that string.
		
		Function<String, Integer> f = s -> s.length();
		
		String names[] = {"Krishna","Vikram", "Temp", "Prasoon", "Singh"};
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String name : names) {
			map.put(name, f.apply(name));
		}
		
		map.forEach((k,v) -> { System.out.println (k + " : " + v);});
		
		
	}

}
