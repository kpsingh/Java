package com.java.leetcode.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/word-subsets/description/
916. Word Subsets
 */
public class LC_Jan10 {
    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        List<String> ans = wordSubsets(words1, words2);
        System.out.println(ans);
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] maxFrequency = new int[26]; // Stores the maximum frequency of each character across all words in `words2`

        // Calculate the maximum frequency of each character in `words2`
        for (String word : words2) {
            int[] frequency = countFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFrequency[i] = Math.max(maxFrequency[i], frequency[i]);
            }
        }

        // Check each word in `words1` against the maxFrequency array
        for (String word : words1) {
            int[] frequency = countFrequency(word);
            if (isUniversal(frequency, maxFrequency)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper function to calculate character frequency
    private static int[] countFrequency(String word) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }
        return frequency;
    }

    // Helper function to check if a word satisfies the universal condition
    private static boolean isUniversal(int[] wordFreq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
