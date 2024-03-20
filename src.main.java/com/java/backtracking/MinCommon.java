package com.java.backtracking;

public class MinCommon {
    public static void main(String[] args) {
        int[] arr1 = {2, 4};
        int[] arr2 = {1, 2};
        int ans = getCommon(arr1, arr2);
        System.out.println(ans);
    }

    private static int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return -1;
    }
}
