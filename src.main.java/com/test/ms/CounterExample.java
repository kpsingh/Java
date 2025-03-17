package com.test.ms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterExample implements Runnable {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private void incrementCounter() {
        for (int i = 1; i <= 10; i++) {
            counter.incrementAndGet(); // Atomic increment
        }
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            service.submit(new CounterExample());
        }

        service.shutdown();
        while (!service.isTerminated()) {
            // Wait until all tasks are finished
        }


        System.out.println("Final Counter Value: " + counter.get());
    }

    @Override
    public void run() {
        incrementCounter();
    }
}
