package com.test.ms;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3; // rotate left by 3 positions → {4,5,6,1,2,3}
        rotate(arr, k);
        System.out.println(Arrays.toString(arr)); // Output: [4, 5, 6, 1, 2, 3]
    }

    private static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // If k > n, take the modulus to get effective rotations

        // Step 1: Reverse first k elements
        reverse(arr, 0, k - 1);
        // Step 2: Reverse remaining elements
        reverse(arr, k, n - 1);
        // Step 3: Reverse entire array
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

