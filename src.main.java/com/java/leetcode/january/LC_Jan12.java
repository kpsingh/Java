package com.java.leetcode.january;

/*
https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
2116. Check if a Parentheses String Can Be Valid
 */
public class LC_Jan12 {
    public static void main(String[] args) {
        String s = s = ")("; // s = "()()", locked = "0000" ||  s = "))()))", locked = "010100"
        String locked = "00";

        boolean result = canBeValid(s, locked);
        System.out.println(result);
    }

    public static boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // odd length string can never be balanced.

        // first try to see validation from let to right
        int open = 0;
        int free = 0;
        // if any moment closing ')' is greater then open and free then it imposible to balance it

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (locked.charAt(i) == '0') {
                free++;
            } else {
                if (open > 0) {
                    open--;
                } else if (free > 0) {
                    free--;
                } else {
                    return false; // this mean close bracket is more and we can't balance it
                }
            }
        }

        open = 0;
        free = 0;
        // now traverl from right to left and do teh same, now treat open will be ')'

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                open++;
            } else if (locked.charAt(i) == '0') {
                free++;
            } else {
                if (open > 0) {
                    open--;
                } else if (free > 0) {
                    free--;
                } else {
                    return false;
                }
            }
        }
        return true;

    }
}
