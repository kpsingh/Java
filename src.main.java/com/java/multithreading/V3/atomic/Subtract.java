package com.java.multithreading.V3.atomic;

public class Subtract implements  Runnable{

    private Count count;

    public Subtract(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            count.val.getAndDecrement();
        }
    }
}
