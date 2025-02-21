package com.java.multithreading.V4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEven {

    public static void main(String[] args) {
        Print p = new Print(1, 10);
        Thread t1 = new Thread(p::printEven);
        Thread t2 = new Thread(p::printOdd);
        t1.start();
        t2.start();
    }
}

class Print {
    private final int max;
    private int i;
    private final ReentrantLock lock;
    private final Condition even;
    private final Condition odd;

    public Print(int start, int max) {
        this.i = start;
        this.max = max;
        lock = new ReentrantLock();
        even = lock.newCondition();
        odd = lock.newCondition();
    }


    public void printEven() {
        while (i <= max) {
            try {
                lock.lock();
                if (i % 2 != 0) {
                    even.await();
                }
                System.out.println(i++);
                odd.signal();
            } catch (InterruptedException ignored) {

            } finally {
                System.out.println("In Side of Even finally");
                lock.unlock();
            }
        }
    }

    public void printOdd() {
        while (i < max) {
            try {
                lock.lock();
                if (i % 2 != 1) {
                    odd.await();
                }
                System.out.println(i++);
                even.signal();
            } catch (InterruptedException ignored) {

            } finally {
                System.out.println("In Side of Odd finally");
                lock.unlock();
            }
        }
    }

}
