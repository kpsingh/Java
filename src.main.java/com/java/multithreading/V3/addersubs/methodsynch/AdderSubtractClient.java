package com.java.multithreading.V3.addersubs.methodsynch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdderSubtractClient {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Adder add = new Adder(count);
        Subtract sub = new Subtract(count);

        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(add);
        es.execute(sub);

        es.shutdown();
        es.awaitTermination(100L, TimeUnit.SECONDS);

        System.out.println(count.getCount());
    }
}
