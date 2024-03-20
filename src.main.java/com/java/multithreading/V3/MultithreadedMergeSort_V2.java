package com.java.multithreading.V3;

import com.java.sorting.MergeSort_V2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultithreadedMergeSort_V2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(5, 2, 4, 6, 7, 8, 9, 5, 4, 6, 7, 3, 2, 1, 1, 2, 34, 5);
        System.out.println(list);
        int left = 0;
        int right = list.size() - 1;
        List<Integer> sorted = sort(list, left, right);
        System.out.println(sorted);

    }

    public static List<Integer> sort(List<Integer> list, int left, int right) throws ExecutionException, InterruptedException {
        if (left >= right) {
            return List.of(list.get(left));
        }
        int mid = left + (right - left) / 2;
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<List<Integer>> leftSorted = service.submit(new Job(list, left, mid));
        Future<List<Integer>> rightSorted = service.submit(new Job(list, mid + 1, right));
        service.shutdown();
        return sort(leftSorted.get(), rightSorted.get());

    }

    private static List<Integer> sort(List<Integer> leftSorted, List<Integer> rightSorted) {
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


    static class Job implements Callable<List<Integer>> {
        int left;
        int right;
        List<Integer> list;

        public Job(List<Integer> list, int left, int right) {
            this.left = left;
            this.right = right;
            this.list = list;
        }


        @Override
        public List<Integer> call() throws Exception {
            return sort(list, left, right);
        }
    }
}
