package com.java.leetcode.january;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
2657. Find the Prefix Common Array of Two Arrays
 */
public class LC_Jan14 {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1}; // {1, 3, 2, 4}
        int[] arr2 = {3, 1, 2}; // {3, 1, 2, 4}
        int[] result = findThePrefixCommonArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(A[i]);
            set2.add(B[i]);
            int count = checkCommon(set1, set2);
            result[i] = count;
        }
        return result;
    }

    private static int checkCommon(Set<Integer> set1, Set<Integer> set2) {
        int count = 0;
        for (int a : set2) {
            if (set1.contains(a)) {
                count++;
            }
        }
        return count;
    }


    public int[] findThePrefixCommonArray_Optimized(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n]; // Array to store the prefix common counts
        int[] freq = new int[51]; // Frequency array for numbers from 1 to 50
        int commonCount = 0; // Tracks how many numbers are common so far

        for (int i = 0; i < n; i++) {
            // Process the current element of A
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                // A[i] becomes common between A and B
                commonCount++;
            }

            // Process the current element of B
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                // B[i] becomes common between A and B
                commonCount++;
            }

            // Store the current prefix common count
            result[i] = commonCount;
        }

        return result;
    }
}
