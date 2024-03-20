package com.java.backtracking;

public class SubsetsWithSumK {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 10, 6, 8}; // 1 1 4 5 || [5, 2, 3, 10, 6, 8] || {5, 2, 7, 2}
        int k = 10;
        int sum = 0;
        int idx = 0;
        int count = countKSumSubsets(arr, idx, sum, k);
        System.out.println("Total subsets sum with sum = " + k + " is : " + count);

    }

    private static int countKSumSubsets(int[] arr, int idx, int sum, int k) {
        if (idx == arr.length) {
            if (sum == k) return 1;
            else return 0;
        }
        int count = 0;
        // taking a decision and exploring all possibilities
        sum += arr[idx];
        count = countKSumSubsets(arr, idx + 1, sum, k);

        // reverting that decision and then exploring all possibilities
        sum -= arr[idx];
        count += countKSumSubsets(arr, idx + 1, sum, k);

        return count;

    }
}
