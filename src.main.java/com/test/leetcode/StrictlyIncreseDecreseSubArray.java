package com.test.leetcode;

import java.security.spec.RSAOtherPrimeInfo;

public class StrictlyIncreseDecreseSubArray {
    public static void main(String[] args) {

        int[] arr = {3, 3, 3}; // 1,4,3,3,2 |
        int increaseMax = 1;
        int n = arr.length;
        // strictly increasing
        int i = 0;
        int j = 1;
        while (j < n) {
            if (arr[j] > arr[j - 1]) {
                increaseMax = Math.max(increaseMax, j - i + 1);
                j++;
            } else {
                i = j;
                j++;
            }
        }

        // strictly decreasing
        int decreasingMax = 1;
        i = 0;
        j = 1;
        while (j < n) {
            if (arr[j] < arr[j - 1]) {
                decreasingMax = Math.max(decreasingMax, j - i + 1);
                j++;
            } else {
                i = j;
                j++;
            }
        }

        //return Math.max(increaseMax, decreasingMax);
        System.out.println(Math.max(increaseMax, decreasingMax));


    }
}

/*
    Applciation has to be complete full stack like UI, back and database
    Applciation should able to save user details like name, age, mobile, address occupation etc
    Applciation should able to modifify the user details
    Applciation should able to retrive the any user details or all user
    Applciation user should apple to delete any user
 */


