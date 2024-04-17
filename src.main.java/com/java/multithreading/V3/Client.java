package com.java.multithreading.V3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayCreator creator = new ArrayCreator(n);
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(Thread.currentThread().getName());
        Future<List<Integer>> submit = service.submit(creator);
        List<Integer> result = submit.get();
        System.out.println("Printing of list by " + Thread.currentThread().getName());
        System.out.println(result);

    }
}

class ArrayCreator implements Callable<List<Integer>> {
    public int n;
    public List<Integer> list;

    public ArrayCreator(int n) {
        this.n = n;
        list = new ArrayList<>();
    }


    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Creation of list by " + Thread.currentThread().getName());
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }
}