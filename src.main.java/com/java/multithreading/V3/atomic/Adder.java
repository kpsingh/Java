package com.java.multithreading.V3.atomic;

public class Adder implements  Runnable{
    private final Count count;
    public Adder( Count count){
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            count.val.getAndIncrement();
        }
    }
}
