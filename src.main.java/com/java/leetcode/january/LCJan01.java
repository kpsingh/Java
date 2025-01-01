package com.java.leetcode.january;

/*
https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
 */
public class LCJan01 {
    public static void main(String[] args) {
        String s = "00111";
        int maxScore = maxScore(s);
        System.out.println(maxScore);

    }

    public static int maxScore(String s) {
        int totalOnes = 0;

        // Count total number of 1s in the string
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        int ones = 0; // Count of ones encountered so far
        int zeros = 0;
        int maxScore = 0;

        for (int i = 0; i < s.length() - 1; i++) { // Split cannot include the last character
            if (s.charAt(i) == '0') zeros++;
            else ones++;

            // Calculate score for current split
            maxScore = Math.max(maxScore, zeros + (totalOnes - ones));
        }

        return maxScore;
    }

}
