package com.java.towpointer;

import java.util.Arrays;

/*
    Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will represent the colors as,

    red -> 0
    white -> 1
    blue -> 2

    Algorithm:

    low tracks the position for 0s (red).
    high tracks the position for 2s (blue).
    mid traverses the array:
    If nums[mid] == 0, swap with low and move both forward.
    If nums[mid] == 1, just move mid forward.
    If nums[mid] == 2, swap with high, move high backward (but keep mid at the same index for rechecking).
 */
public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2,1,1,0,0,0};

        // one pass (O(N) time complexity) and O(1) space complexity.
        int low = 0;
        int hi = arr.length - 1;
        int mid = 0;
        while (mid <= hi) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, hi);
                hi--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
