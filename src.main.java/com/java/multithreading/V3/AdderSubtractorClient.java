package com.java.multithreading.V3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdderSubtractorClient {
    public static void main(String[] args) throws InterruptedException {
        MyNumber num = new MyNumber();
        num.i = 0;
        Adder add = new Adder(num);
        Substractor sub = new Substractor(num);
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(add);
        es.execute(sub);
        es.shutdown();
        es.awaitTermination(100L, TimeUnit.SECONDS);
        System.out.println(num.i);
    }
}
