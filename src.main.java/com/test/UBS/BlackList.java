package com.test.UBS;

import java.util.Arrays;

public class BlackList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        System.out.println("original : " + Arrays.toString(arr));
        System.out.println("left : " + Arrays.toString(left));
        System.out.println("right : " + Arrays.toString(right));
    }
}
