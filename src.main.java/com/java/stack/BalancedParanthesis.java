package com.java.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an expression string A, examine whether the pairs
and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
 */
public class BalancedParanthesis {
    public static void main(String[] args) {
        String s = "{([])}";
        System.out.println(solve(s) == 1 ? "Balanced" : "UnBalanced");
    }

    private static int solve(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return 0; // if stack is empty then it is not balanced
                if (ch == ')' && stack.peek() != '(' || ch == '}' && stack.peek() != '{'
                        || ch == ']' && stack.peek() != '[') {
                    return 0;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
