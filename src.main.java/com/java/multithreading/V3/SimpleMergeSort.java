package com.java.multithreading.V3;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;

public class SimpleMergeSort {
    public static void main(String[] args) {
        List<Integer> list = List.of(5, 2, 4, 6, 7, 8, 9, 5, 4, 6, 7, 3, 2, 1, 1, 2, 34, 5);
        int left = 0;
        int right = list.size() - 1;
        long start = System.currentTimeMillis();
        List<Integer> sorted = mergeSort(list, left, right);
        long end = System.currentTimeMillis();
        System.out.println(sorted);
        System.out.print("Total time taken : ");
        System.out.println(end - start);
    }

    private static List<Integer> mergeSort(List<Integer> list, int left, int right) {
        if (left >= right) {
            return List.of(list.get(left));
        }
        int mid = left + (right - left) / 2;
        List<Integer> leftSorted = mergeSort(list, left, mid);
        List<Integer> rightSorted = mergeSort(list, mid + 1, right);
        return merge(leftSorted, rightSorted);
    }

    private static List<Integer> merge(List<Integer> leftSorted, List<Integer> rightSorted) {
        if (leftSorted == null || rightSorted == null) {
            return leftSorted != null ? leftSorted : rightSorted;
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < leftSorted.size() && j < rightSorted.size()) {
            if (leftSorted.get(i) < rightSorted.get(j)) {
                ans.add(leftSorted.get(i));
                i++;
            } else {
                ans.add(rightSorted.get(j));
                j++;
            }
        }

        while (i < leftSorted.size()) {
            ans.add(leftSorted.get(i));
            i++;
        }
        while (j < rightSorted.size()) {
            ans.add(rightSorted.get(j));
            j++;
        }

        return ans;

    }
}
