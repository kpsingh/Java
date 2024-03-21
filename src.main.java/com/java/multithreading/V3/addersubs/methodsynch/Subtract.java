package com.java.multithreading.V3.addersubs.methodsynch;

public class Subtract implements Runnable {
    private final Count count;


    public Subtract(Count count) {
        this.count = count;

    }
    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            count.subtract(i);
        }
    }
}
