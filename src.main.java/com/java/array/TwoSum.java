package com.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Find the pair of all elements whose sum is = target,
duplicates pairs are not allowed

 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {-1, 7, 0, 1, 2, 2, 5};
        int target = 1;
        // Since it has been asked the element and not the index,
        // we can sort the array and then apply two pointers

        Arrays.sort(arr);
        List<Pair> ans = twoSumpPairs(arr, target, 0, arr.length - 1);
        System.out.println(ans);

    }

    private static List<Pair> twoSumpPairs(int[] arr, int target, int left, int right) {
        List<Pair> ans = new ArrayList<>();
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                ans.add(new Pair(arr[left], arr[right]));
                int leftVal = arr[left];
                int rightVal = arr[right];

                // Skip duplicates¯
                //The duplicate check should be done after processing the current pair, not at the beginning
                // of the loop — otherwise you might skip valid elements or miss the only pair that could be
                // valid.

                while (left < right && arr[left] == leftVal) left++;
                while (left < right && arr[right] == rightVal) right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}