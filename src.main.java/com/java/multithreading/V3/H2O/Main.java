package com.java.multithreading.V3.H2O;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();

        Semaphore hydrozenSemaphore = new Semaphore(2);
        Semaphore oxezenSemaphore = new Semaphore(0);

        Hydrozen h = new Hydrozen(h2O, hydrozenSemaphore, oxezenSemaphore);
        Oxen o = new Oxen(h2O, hydrozenSemaphore, oxezenSemaphore);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(h);
        service.execute(o);

        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);


        Semaphore s = new Semaphore(-1);

    }
}
