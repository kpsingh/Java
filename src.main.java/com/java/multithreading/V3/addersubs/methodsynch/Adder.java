package com.java.multithreading.V3.addersubs.methodsynch;

import com.java.multithreading.V3.MyNumber;

public class Adder implements Runnable {
    private final Count count;

    public Adder(Count count) {
        this.count = count;

    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            count.add(i);
        }
    }
}
