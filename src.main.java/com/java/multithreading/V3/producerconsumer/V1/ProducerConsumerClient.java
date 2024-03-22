package com.java.multithreading.V3.producerconsumer.V1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ProducerConsumerClient {
    public static void main(String[] args) {
        Semaphore odd = new Semaphore(1);
        Semaphore even = new Semaphore(0);
        Number num = new Number(1);

        OddProducer oddProducer = new OddProducer(odd, even, num);
        EvenProducer evenProducer = new EvenProducer(odd, even, num);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(oddProducer);
        service.execute(evenProducer);
        service.shutdown();

    }
}
