package com.java.queue;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/top-k-frequent-words/description/?envType=problem-list-v2&envId=ou2x7z6r
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 */
public class TopKFrequentWorld {
    public static void main(String[] args) {
       // String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;

        List<String> ans = topKFrequent(arr, k);
        System.out.println(ans);
    }

    private static List<String> topKFrequent(String[] arr, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // create priority queue min priority queue based on the value of count
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            q.add(e);
            if (q.size() > k) {
                q.poll();
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        while (!q.isEmpty()) {
            list.add(q.poll());
        }

        return list.stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue() == e2.getValue()) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return e2.getValue() - e1.getValue();
                })
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
