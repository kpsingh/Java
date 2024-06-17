package com.java.bitmanipulation;

/*
Given an array of integers, every element appears thrice except for one, which occurs once.

 */
public class SingleNumberII {
    public static void main(String[] args) {

        int[] arr = {4, 3, 5, 4, 3, 5, 4, 3};
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for (int a : arr) {
                if (((a >> i) & 1) == 1) {
                    count++;
                }
            }
            // note here we need to divide by 3 as every element appear thrice except one
            if (count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        System.out.println(ans);

    }
}
