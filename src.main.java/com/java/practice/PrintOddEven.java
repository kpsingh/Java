package com.java.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEven {

    public static void main(String[] args) {
        Print print = new Print(1, 10);
        Thread t1 = new Thread(print::printEven);
        Thread t2 = new Thread(print::printOdd);
        t1.start();
        t2.start();
    }
}

class Print {
    private int start;
    private final int end;
    private final ReentrantLock lock;
    private final Condition even;
    private final Condition odd;

    Print(int start, int end) {
        this.start = start;
        this.end = end;
        lock = new ReentrantLock();
        even = lock.newCondition();
        odd = lock.newCondition();
    }

    public void printEven() {
        while (start <= end) {
            lock.lock();
            try {
                if (start % 2 != 0) {
                    // start is odd
                    even.await();
                }
                System.out.println(start++);
                odd.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printOdd() {
        while (start < end) {
            lock.lock();
            try {
                if (start % 2 != 1) {
                    // even number
                    odd.await();
                }
                System.out.println(start++);
                even.signal();
            } catch (InterruptedException ex) {

            } finally {
                lock.unlock();
            }
        }
    }
}