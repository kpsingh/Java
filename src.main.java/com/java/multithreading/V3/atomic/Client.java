package com.java.multithreading.V3.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Adder adder = new Adder(count);
        Subtract subtract = new Subtract(count);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(adder);
        service.execute(subtract);

        service.shutdown();
        service.awaitTermination(100L, TimeUnit.SECONDS);
        System.out.println(count.val.get());
    }
}
