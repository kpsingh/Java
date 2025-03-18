package com.test.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3; // rotate the array by 3 position {4,5,6,1,2,3}
        rotate(arr, k);
        //System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] arr, int k) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, k, temp, 0, arr.length - k);
        System.arraycopy(arr, 0, temp, arr.length - k, k);
        System.out.println(Arrays.toString(temp));

    }
}
