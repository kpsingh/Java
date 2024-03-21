package com.java.multithreading.V3.addersubs.synch;

import com.java.multithreading.V3.MyNumber;

import java.util.concurrent.locks.Lock;

public class Substractor implements Runnable {
    private final MyNumber num;

    public Substractor(MyNumber num) {
        this.num = num;

    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            synchronized (num) {
                num.value -= i;
            }
        }
    }
}
