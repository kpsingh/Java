package com.test.leetcode;

import java.sql.Time;
import java.util.*;

public class ValidParenthesesString {
    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        //  String s = "(*))";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        int open = 0;
        int idx = 0;
        int n = s.length();
        Map<String, Boolean> visited = new HashMap<>();
        return validate(s, open, idx, visited);
    }

    private static boolean validate(String s, int open, int idx, Map<String, Boolean> visited) {
        if (idx == s.length()) {
            return open == 0;
        }
        if (visited.containsKey("" + idx + open)) {
            return visited.get("" + idx + open);
        }
        boolean isValid = false;
        char ch = s.charAt(idx);

        if (ch == '(') {
            isValid |= validate(s, open + 1, idx + 1, visited);
        } else if (ch == '*') {
            // three possibility
            isValid |= validate(s, open + 1, idx + 1, visited); // considering  (
            isValid |= validate(s, open, idx + 1, visited);// considering  *
            if (open > 0) {
                isValid |= validate(s, open - 1, idx + 1, visited);// considering  )
            }
        } else if (open > 0) {
            isValid |= validate(s, open - 1, idx + 1, visited);// considering  )
        }
        visited.put("" + idx + open, isValid);
        return isValid;
    }

    public boolean checkValidString_V2(String s) {
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Check if char = '(', push its index into stack open
            if (ch == '(') {
                open.push(i);
            } else
                // Check if char = '*', push its index into stack star
                if (ch == '*') {
                    star.push(i);
                } else if (ch == ')') {
                    // Check if open stack is not empty, pop  from open
                    if (!open.isEmpty()) {
                        open.pop();
                    } else
                        // If open is empty, Check if star is not empty, pop from star
                        if (!star.isEmpty()) {
                            star.pop();
                        } else
                        // If both are empty, return false
                        {
                            return false;
                        }
                }
        }

        // Check for any leftovers
        // Check if any element is still present in open
        while (!open.isEmpty()) {
            // If star is empty, s is invalid, return false
            if (star.isEmpty()) {
                return false;
            } else
                // Check if top index in open < top index in star
                if (open.peek() < star.peek()) {
                    // pop from both open and star
                    open.pop();
                    star.pop();
                } else
                // If top index in open > top index in star, s is invalid
                {
                    return false;
                }
        }
        return true;
    }
}
