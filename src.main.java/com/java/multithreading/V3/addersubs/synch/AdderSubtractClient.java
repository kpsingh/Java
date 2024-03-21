package com.java.multithreading.V3.addersubs.synch;

import com.java.multithreading.V3.MyNumber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubtractClient {
    public static void main(String[] args) throws InterruptedException {
        MyNumber num = new MyNumber();
        num.value = 0;

        Adder add = new Adder(num);
        Substractor sub = new Substractor(num);
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(add);
        es.execute(sub);
        es.shutdown();
        es.awaitTermination(100L, TimeUnit.SECONDS);
        System.out.println(num.value);
    }
}
