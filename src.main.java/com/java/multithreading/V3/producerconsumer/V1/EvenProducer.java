package com.java.multithreading.V3.producerconsumer.V1;

import java.util.concurrent.Semaphore;

public class EvenProducer implements Runnable{

    Semaphore odd;
    Semaphore even;
    Number num;

    public EvenProducer(Semaphore odd, Semaphore even, Number num){
        this.odd = odd;
        this.even = even;
        this.num = num;
    }

    @Override
    public void run() {
        while (num.val <= 10){
            try {
                even.acquire();
                System.out.println("Even Thread : " + num.val++);
                Thread.sleep(1000);
                odd.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
