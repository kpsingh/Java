package com.java.array;
/*
Partition Equal Subset Sum
https://leetcode.com/problems/partition-equal-subset-sum/description/?envType=daily-question&envId=2025-04-07
 */

import java.util.stream.IntStream;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        boolean result = canPartition(arr);
        System.out.println(result);
    }

    private static boolean canPartition(int[] arr) {
        boolean result = false;

        int sum = IntStream.of(arr).sum();
        if(sum % 2 != 0) {
            return result; //  sum is add then we can't divide in two parts
        }

        return result;
    }
}
