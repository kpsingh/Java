package com.java.multithreading.V3.H2O;

import java.util.concurrent.Semaphore;

public class Hydrozen implements Runnable{
    private final H2O  h2O;
    private final Semaphore h;
    private  final Semaphore o;

    public Hydrozen(H2O h2O, Semaphore h, Semaphore o) {
        this.h2O = h2O;
        this.h = h;
        this.o = o;
    }

    @Override
    public void run(){
        h.release();
        h2O.releaseHydrogen();
        if (h.availablePermits() == 0){
            o.release();
        }
    }
}
