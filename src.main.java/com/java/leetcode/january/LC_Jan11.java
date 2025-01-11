package com.java.leetcode.january;

/*
https://leetcode.com/problems/construct-k-palindrome-strings/description/
1400. Construct K Palindrome Strings

Key Observations:
Palindrome Requirements:

A palindrome has at most one character with an odd frequency (in the middle).
If a character appears an even number of times, it can fully participate in a palindrome.
Conditions:

The number of odd-frequency characters in
𝑠
s must not exceed
𝑘
k, as each odd-frequency character can only be used as the center of one palindrome.
𝑘
k must not exceed the length of the string (
𝑘
≤

 */
public class LC_Jan11 {
    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;

        System.out.println(canConstruct(s, k));
    }

    public static boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        if (s.isEmpty()) return true;
        if (k == s.length()) return true;

        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}
