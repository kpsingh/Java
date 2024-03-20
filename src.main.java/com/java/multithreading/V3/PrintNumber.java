package com.java.multithreading.V3;

public class PrintNumber implements  Runnable {
    int i;
    PrintNumber(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("Number : " + i + " by " + Thread.currentThread().getName());
    }
}
