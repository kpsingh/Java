package com.java.leetcode.february;

import java.util.Arrays;

/*
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
1752. Check if Array Is Sorted and Rotated


we can count the number of inversions (where arr[i] > arr[i+1]).

    If the array is sorted, there should be 0 inversions.
    If the array is a rotated sorted array, there should be exactly 1 inversion.
 */
public class LC_FEB02 {
    public static void main(String[] args) {
        int[] arr = {6,10,6};
        boolean isArraySortedAndRotated = check(arr);
        System.out.println(isArraySortedAndRotated);
    }

    private static boolean check(int[] arr) {
        int numberOfInversions = 0;
        for(int i=0; i<arr.length -1; i++) {
            if(arr[i] > arr[i+1]) {
                numberOfInversions++;
            }
        }

        return numberOfInversions <= 1;

    }

}
