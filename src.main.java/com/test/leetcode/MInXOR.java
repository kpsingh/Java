package com.test.leetcode;

import java.util.Arrays;
import java.util.*;

public class MInXOR {
    public static void main(String[] args) {
        int[] arr = {2, 1, 9, 12};
        //int[] arr = {32, 1, 25,11,2};
        int k = 21;
        int ans = shortestSubarray(arr, k);
        System.out.println(ans
        );

    }


    public static int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int minLength = n + 1;

        for (int i = 0; i < n + 1; i++) {
            while (!stack.isEmpty() && prefixSum[i] - prefixSum[stack.peek()] >= K) {
                minLength = Math.min(minLength, i - stack.poll());
            }
            while (!stack.isEmpty() && prefixSum[i] <= prefixSum[stack.peekLast()]) {
                stack.pollLast();
            }
            stack.add(i);
        }

        return minLength == n + 1 ? -1 : minLength;
    }


    public static int minimumSubarrayLength(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        if (max >= k) return 1;

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                long y = nums[j];
                x = (x | y);
                if (x >= k) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }

       return result != Integer.MAX_VALUE ? result : -1;

    }
}
