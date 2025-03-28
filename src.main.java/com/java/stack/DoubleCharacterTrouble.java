package com.java.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.
 */
public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        String s = "abccbc";
        s = transform(s);
        System.out.println(s);
    }

    private static String transform(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
