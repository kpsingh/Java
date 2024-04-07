package com.test.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinRemovaltoMakeValidParenthesis {
    public static void main(String[] args) {

        String s = "))(("; // "lee(t(c)o)de)", a)b(c)d, ))((
        Deque<Node> stack = new ArrayDeque<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == '(') {
                stack.push(new Node(ch, i));
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek().ch == '(') {
                    stack.pop();
                } else {
                    arr[i] = 'A';
                }
            }
        }

        while (!stack.isEmpty()) {
            int k = stack.poll().idx;
            arr[k] = 'A';
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch != 'A') {
                sb.append(ch);
            }
        }

        String result = sb.toString();
        System.out.println(result);

    }

    static class Node {
        char ch;
        int idx;

        Node(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

}


