package com.java.backtracking;

import java.util.ArrayList;

public class PrintAllNumber {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        int n = 2;
        // Print all the 3-digit number possible with 1 & 2
        printNumber(arr, n, new ArrayList<Integer>());
        System.out.println("Total : " + count);
    }

    private static void printNumber(int[] arr, int n, ArrayList<Integer> list) {
        if (n == 0){
            System.out.println(list);
            count++;
            return;
        }
        for (int j : arr) {
            // choose a number
            list.add(j);
            // explore further
            printNumber(arr, n - 1, list);
            // remove the chosen and choose different
            list.remove(list.size() - 1);
        }
    }
}
