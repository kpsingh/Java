package com.test.ms;

import java.util.Arrays;

public class SerachInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 12, 14, 15, 17, 45, 67, 78, 89};
        //  Arrays.sort(arr);
        int k = 4;
        int searchIndex = binarySearch(arr, 0, arr.length - 1, k);
        System.out.println(searchIndex);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        int low = start - 1;
        int hi = end; // possible right position
        while (low + 1 < hi) {
            int mid = low + (hi - low) / 2;
            if (ok(arr, mid, target)) {
                hi = mid;
            } else {
                low = mid;
            }
        }
        return arr[hi] == target ? hi : -1;

    }

    private static boolean ok(int[] arr, int mid, int target) {
        return arr[mid] >= target;
    }
}
