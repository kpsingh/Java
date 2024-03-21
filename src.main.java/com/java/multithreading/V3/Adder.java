package com.java.multithreading.V3;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private final MyNumber num;
    private  final Lock lock;

    public Adder(MyNumber num, Lock lock) {
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            lock.lock();
            num.value += i;
            lock.unlock();
        }
    }
}
