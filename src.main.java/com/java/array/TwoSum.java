package com.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Find the pair of all elements whose sum is = target,
duplicates pairs are not allowed

 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {-1, 7, 0, 1, 2, 2, 5};
        int target = 1;
        List<Pair> ans = twoSumpPairs(arr, target);
        System.out.println(ans);

    }

    private static List<Pair> twoSumpPairs(int[] arr, int target) {
        List<Pair> ans = new ArrayList<>();
        // Since it has been asked the element and not the index,
        // we can sort the array and then apply two pointers

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // ignore the duplicate by moving the pointer to last duplicate element
            while (arr[left] == arr[left + 1] && left != right) {
                left++;
            }

            while (arr[right] == arr[right - 1] && left != right) {
                right--;
            }

            int sum = arr[left] + arr[right];

            if (sum == target) {
                ans.add(new Pair(arr[left], arr[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}

class Pair {
    int a;
    int b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "{" + a + "," + b + "}";
    }
}