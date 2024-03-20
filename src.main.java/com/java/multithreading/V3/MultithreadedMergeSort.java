package com.java.multithreading.V3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultithreadedMergeSort {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(5, 2, 4, 6, 7, 8, 9, 5, 4, 6, 7, 3, 2, 1, 1, 2, 34, 5);
        int left = 0;
        int right = list.size() - 1;
        MultithreadedMergeSort mtms = new MultithreadedMergeSort();
        //long start = System.currentTimeMillis();
        List<Integer> sorted = mtms.mergeSort(list, left, right, mtms);
        //long end = System.currentTimeMillis();
        System.out.println(sorted);
        //System.out.print("Total time taken : ");
        // System.out.println(end - start);
    }

    public List<Integer> mergeSort(List<Integer> list, int left, int right, MultithreadedMergeSort mtms) throws ExecutionException, InterruptedException {
        if (left >= right) {
            return List.of(list.get(left));
        }
        int mid = left + (right - left) / 2;
        ExecutorService service = Executors.newFixedThreadPool(2);

        SortJob job1 = new SortJob(list, left, mid, mtms);
        Future<List<Integer>> leftSorted = service.submit(job1);

        SortJob job2 = new SortJob(list, mid + 1, right, mtms);
        Future<List<Integer>> rightSorted = service.submit(job2);

        return mtms.merge(leftSorted.get(), rightSorted.get());
    }

    private List<Integer> merge(List<Integer> leftSorted, List<Integer> rightSorted) {
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

class SortJob implements Callable<List<Integer>> {
    int left;
    int right;
    List<Integer> list;
    MultithreadedMergeSort mtms;

    SortJob(List<Integer> list, int left, int right, MultithreadedMergeSort mtms) {
        this.list = list;
        this.left = left;
        this.right = right;
        this.mtms = mtms;
    }

    @Override
    public List<Integer> call() throws Exception {
        return mtms.mergeSort(list, left, right, mtms);
    }

}

