package com.java.streams.V1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/top-k-frequent-words/
 */

public class TopKFrequentWords_692 {

	public static void main(String[] args) {
		// String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		int k = 4;

		List<String> topKFrequent = topKFrequent_V1(words, k);

		topKFrequent.forEach(s -> System.out.println(s));
	}

	public static List<String> topKFrequent_V2(String[] words, int k) {

		Map<String, Integer> map = new HashMap<>(); // To make sure key's are sorted order

		for (String w : words) {
			map.merge(w, 1, (V1, V2) -> V1 + V2);
		}

		Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,
				b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			pq.offer(e);
		}
		List<String> result = new ArrayList<>();
		while (k > 0) {
			k--;
			result.add(pq.poll().getKey());
		}
		return result;

	}

	public static List<String> topKFrequent_V1(String[] words, int k) {

		Map<String, Integer> map = new TreeMap<>();

		for (String s : words) {
			map.merge(s, 1, (v1, v2) -> v1 + v2);

		}

		/**
		 * 
		 * for(String w : words){ int c = map.getOrDefault(w,0); c++; map.put(w,c); }
		 */

		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
				
				
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1)
				.map(e -> e.getKey()).collect(Collectors.toList());

	}
}
