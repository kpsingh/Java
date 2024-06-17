package com.java.towpointer;

/*
Given a sorted (ASC) array and k, find out if there exist two element such that arr[i] + arr[j] = k; i != j
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8, 9, 17, 25};
        int target = 15;
        boolean pairExist = findPair(arr, target);
        System.out.println(pairExist);
    }

    private static boolean findPair(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
