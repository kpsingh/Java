package com.test.ms;

import java.util.Arrays;

public class RotateArray2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3; // rotate k element
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // in case k > n, then relative rotation

        reverse(arr, 0, k - 1); // reverse first k element
        reverse(arr, k, n - 1); // rotate remaining element
        reverse(arr, 0, n - 1); // reverse the entire array again

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
