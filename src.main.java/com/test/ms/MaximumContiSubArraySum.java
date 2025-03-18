package com.test.ms;

public class MaximumContiSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -1, 3, 4, -1, 2, -1, -5, -4};
        int maxSum = solve(arr);
        System.out.println(maxSum);
    }

    private static int solve(int[] arr) {
        int maxSum = arr[0];// Initialize with first element
        int currSum = arr[0];// Current sum starts with first element
        for (int i = 1; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = arr[i];// Potential new start of the subarray
            } else {
                currSum += arr[i];
            }
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
