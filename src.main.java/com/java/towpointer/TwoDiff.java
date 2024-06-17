package com.java.towpointer;

public class TwoDiff {
    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, 3, 6, 8};
        int k = 10;
        boolean isDiffPair = findDiffPair(arr, k);
        System.out.println(isDiffPair);
    }

    private static boolean findDiffPair(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return false;
        }
        int j = 0, i = 1;
        while (i < arr.length) {
            if (arr[i] - arr[j] == k) {
                return true;
            } else if (arr[i] - arr[j] > k) {
                j++;
                if (i == j)
                    i++;
            } else if (arr[i] - arr[j] < k) {
                i++;
            }
        }
        return false;
    }

}
