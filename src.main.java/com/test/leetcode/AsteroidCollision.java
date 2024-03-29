package com.test.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {-2, 2, 1, -2};
        int[] ans = asteroidCollision(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] asteroidCollision(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0 && st.peek() > 0) {
                if (st.peek() == Math.abs(arr[i])) {
                    st.pop();
                } else if (st.peek() < Math.abs(arr[i])) {
                    while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])) {
                        st.pop();
                    }
                    if(st.peek() == Math.abs(arr[i])){
                        st.pop();
                    }
                    else if (st.isEmpty() || st.peek() < 0) {
                        st.push(arr[i]);
                    }
                }
            } else {
                st.push(arr[i]);
            }
        }

        int n = st.size();
        int[] ans = new int[n];
        while (n > 0) {
            ans[--n] = st.pop();
        }

        return ans;

    }
}
