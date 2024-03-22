package com.java.multithreading.V3.producerconsumer.V1;

import java.util.concurrent.Semaphore;

public class OddProducer implements Runnable{
    Semaphore odd;
    Semaphore even;
    Number num;
    public OddProducer(Semaphore odd, Semaphore even, Number num) {
        this.odd = odd;
        this.even =even;
        this.num = num;
    }

    @Override
    public void run() {
        while (num.val < 10){
            try {
                odd.acquire();
                System.out.println("Odd Thread : " + num.val++);
                Thread.sleep(1000);
                even.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
