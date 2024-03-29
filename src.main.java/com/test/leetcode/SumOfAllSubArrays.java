package com.test.leetcode;

public class SumOfAllSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 3};
        int sum = findSum(arr);
        System.out.println(sum);
    }

    private static int findSum(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += (n - i) * (i + 1) * arr[i];
        }
        return sum;
    }
}
