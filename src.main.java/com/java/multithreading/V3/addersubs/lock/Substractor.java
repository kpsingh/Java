package com.java.multithreading.V3.addersubs.lock;

import com.java.multithreading.V3.MyNumber;

import java.util.concurrent.locks.Lock;

public class Substractor implements Runnable {
    private final MyNumber num;
    private  final Lock lock;


    public Substractor(MyNumber num, Lock lock) {
        this.num = num;
        this.lock = lock;

    }


    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {

            num.value -= i;

        }
    }
}
