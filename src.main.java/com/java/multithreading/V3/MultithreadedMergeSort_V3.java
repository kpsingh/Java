package com.java.multithreading.V3;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedMergeSort_V3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(5, 2, 4, 6, 7, 8, 9, 5, 4, 6, 7, 3, 2, 1, 1, 2, 34, 5);
        ExecutorService service = Executors.newCachedThreadPool();
        Sorter sorterJob = new Sorter(list, service);
        Future<List<Integer>> sortedListFuture = service.submit(sorterJob);
        System.out.println(sortedListFuture.get());
        service.shutdown();

    }
}
