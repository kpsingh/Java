package com.java.multithreading.V3.H2O;

import java.util.concurrent.Semaphore;

public class Oxen implements  Runnable{
    private final H2O  h2O;
    private final Semaphore h;
    private  final Semaphore o;

    public Oxen(H2O h2O, Semaphore h, Semaphore o) {
        this.h2O = h2O;
        this.h = h;
        this.o = o;
    }

    @Override
    public void run() {
        try {
            o.acquire();
            h2O.releaseOxygen();
            h.release(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
