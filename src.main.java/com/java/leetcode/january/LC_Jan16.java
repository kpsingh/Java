package com.java.leetcode.january;
/*
https://leetcode.com/problems/bitwise-xor-of-all-pairings/?envType=daily-question&envId=2025-01-16
2425. Bitwise XOR of All Pairings
 */
public class LC_Jan16 {
    public static void main(String[] args) {
        int[] arr = {2,1,3};
        int[] arr2 = {10,2,5,0};
        int result = xorAllNums(arr, arr2);
        System.out.println(result);
    }

    public  static int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;
        for(int a : nums1){
            for(int b : nums2){
                result = result ^ a ^ b;
            }
        }
        return result;
    }
}
