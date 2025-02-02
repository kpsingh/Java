package com.java.leetcode.february;

import java.util.Arrays;

/*
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
1752. Check if Array Is Sorted and Rotated
 */
public class LC_FEB02 {
    public static void main(String[] args) {
        int[] arr = {6,10,6};
        boolean isArraySortedAndRotated = check(arr);
        System.out.println(isArraySortedAndRotated);
    }

    private static boolean check(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int maxIndex = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                maxIndex = i;
                break;
            }
        }

        if (maxIndex == -1) {
            return true;
        }

        for (int i = maxIndex + 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[0] || arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return arr[arr.length - 1] <= arr[0];

    }

}
