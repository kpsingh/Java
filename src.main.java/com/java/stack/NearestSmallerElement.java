package com.java.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
Input : A = [4, 5, 2, 10, 8]
Output :  [-1, 4, -1, 2, 2]
 */
public class NearestSmallerElement {
    public static void main(String[] args) {
        //int[] arr = {4, 5, 2, 10, 8};
        // int[] arr = {3,2,1};
        int[] arr = {39,27,11,4,24,32,32,1};
        ArrayList<Integer> result = prevSmaller(arr);
        System.out.println(result);
    }

    private static ArrayList<Integer> prevSmaller(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : arr) {
            while (!stack.isEmpty() && stack.peek() >= a) {
                stack.pop();
            }
            result.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(a);
        }

        String join = String.join(" ", "Krishna", "Pratap", "Singh");
        System.out.println(join);

        return result;
    }
}
