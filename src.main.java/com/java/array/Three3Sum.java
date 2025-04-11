package com.java.array;

import javax.print.attribute.standard.PrinterURI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum/description/
 */
public class Three3Sum {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        //int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr = {0, 0, 0};

        int target = 0;
        // Step 1 : sort the array
        Arrays.sort(arr);
        System.out.println(threeSum(arr));

    }

    public static List<List<Integer>> threeSum(int[] arr) {
        result = new ArrayList<>();
        int n = arr.length;

        // Step 1: Sort the array
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int n1 = arr[i];
            int target = -n1;

            // Step 2: Use two-pointer to find the rest of the two numbers
            twoSum(arr, target, i + 1, n - 1);
        }

        return result;
    }

    private static void twoSum(int[] arr, int target, int start, int end) {
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                // Found a valid triplet
                result.add(Arrays.asList(-target, arr[start], arr[end]));

                // Skip duplicates for second and third numbers
                int startValue = arr[start];
                int endValue = arr[end];

                while (start < end && arr[start] == startValue) start++;
                while (start < end && arr[end] == endValue) end--;
            }
        }
    }
}
