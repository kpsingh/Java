package com.java.multithreading.V3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> arrayToSort;

    public Sorter(List<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) {
            return arrayToSort; // single element is already sorted.
        }

        // divide the array into two Part
        int n = arrayToSort.size();
        int mid = n / 2;
        List<Integer> leftArray = arrayToSort.subList(0, mid);
        List<Integer> rightArray = arrayToSort.subList(mid, n);

        // now submit the task to executor so they sort and return to us
        Sorter leftToSort = new Sorter(leftArray);
        Sorter rightToSort = new Sorter(rightArray);

        ExecutorService service = Executors.newCachedThreadPool();
        Future<List<Integer>> leftFuture = service.submit(leftToSort);
        Future<List<Integer>> rightFuture = service.submit(rightToSort);

        // now get the left sorted and right sorted and merge them

        List<Integer> leftSorted = leftFuture.get();
        List<Integer> rightSorted = rightFuture.get();
        service.shutdown();

        return merge(leftSorted, rightSorted);
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
