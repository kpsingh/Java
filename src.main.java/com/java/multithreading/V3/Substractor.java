package com.java.multithreading.V3;

public class Substractor implements Runnable {
    private final MyNumber num;

    public Substractor(MyNumber num) {
        this.num = num;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            num.i -= i;
        }
    }
}
