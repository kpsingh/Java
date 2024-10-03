package com.java.towpointer;

import java.util.Arrays;

/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.


 */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int B = 5;
        int[] ans = findSubArray(arr, B);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] findSubArray(int[] arr, int b) {
        int left = 0, right = 1;
        int sum = arr[left];
        while (right < arr.length) {
            sum += arr[right];
            if (sum == b) {
                return new int[]{left, right};
            }else if (sum < b) {
                right++;
            }else if (sum > b) {
                sum -= arr[left];
                left++;
            }
        }
        return new int[] {-1};
    }
}
