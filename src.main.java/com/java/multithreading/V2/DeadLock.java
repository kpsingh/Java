package com.java.multithreading.V2;

public class DeadLock {

    public static void main(String[] args) throws InterruptedException {

        A a = new A();
        Thread t1 = new Thread(() -> a.m1());
        Thread t2 = new Thread(() -> a.m2());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

class A {

    Object key1 = new Object();
    Object key2 = new Object();

    public void m1() {

        synchronized (key1) {

            System.out.println("I'm at method - 1 " + Thread.currentThread().getName());
            m2();
        }

    }

    public void m2() {

        synchronized (key2) {

            System.out.println("I'm at method - 2 " + Thread.currentThread().getName());
            m3();
        }

    }

    public void m3() {

        synchronized (key1) {

            System.out.println("I'm at method - 3");
        }

    }
}