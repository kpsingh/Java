package com.java.leetcode.january;
/*
https://leetcode.com/problems/number-of-ways-to-split-array/description/
 */
public class LCJan03 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,0};
        int numberOfSplit = waysToSplitArray(arr);
        System.out.println(numberOfSplit);
    }

    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int count = 0;
        int totalSum = 0;
        for(int a : nums){
            totalSum += a;
        }
        int currSum  = 0;
        for(int i = 0; i < n -1; i++){
            currSum = currSum + nums[i];
            if(currSum >= totalSum - currSum){
                count++;
            }
        }
        return count;
    }
}
