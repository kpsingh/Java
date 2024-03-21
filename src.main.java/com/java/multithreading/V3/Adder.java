package com.java.multithreading.V3;

public class Adder implements Runnable {
    private final MyNumber num;

    public Adder(MyNumber num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            num.i += i;
        }
    }
}
