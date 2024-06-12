package com.java.multithreading.V4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicDeadLock {
    Lock lockA = new ReentrantLock();
    Lock lockB = new ReentrantLock();

    public static void main(String[] args) {
        BasicDeadLock basicDeadLock = new BasicDeadLock();
        basicDeadLock.execute();
    }

    private void execute() {

        new Thread(this::processThis).start();
        new Thread(this::pocessThat).start();
    }

    public void processThis() {
        lockA.lock();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // do some stuffs
        lockB.lock();
        // do some stuffs
        System.out.println("In side process THIS");
        lockA.unlock();
        lockB.unlock();
    }

    public void pocessThat() {
        lockB.lock();
        // do some stuff

        lockA.lock();
        // do some stuffs
        System.out.println("In side process THAT");
        lockB.unlock();
        lockA.unlock();
    }
}
