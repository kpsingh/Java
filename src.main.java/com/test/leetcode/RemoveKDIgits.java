package com.test.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDIgits {
    public static void main(String[] args) {
        int ans = Integer.MAX_VALUE;
        String s = "0200";
        int k = 1;
        s = removeKdigits(s, k);
        System.out.println(s);
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Deque<Character> st = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while (!st.isEmpty() && k > 0) {
            st.pop(); // in case elements where increasing order
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        String result = sb.reverse().toString();
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        result = result.substring(i, result.length());
        return result.length() == 0 ? "0" : result;
    }
}
