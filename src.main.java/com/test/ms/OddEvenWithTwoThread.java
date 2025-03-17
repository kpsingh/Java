package com.test.ms;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenWithTwoThread {
    private int start;
    private final int end;
    Lock lock;
    Condition odd;
    Condition even;

    public OddEvenWithTwoThread(int start, int end) {
        this.start = start;
        this.end = end;
        lock = new ReentrantLock();
        odd = lock.newCondition();
        even = lock.newCondition();
    }

    public void printEven() {
        while (start <= end) {
            try {
                lock.lock();
                if (start % 2 != 0) {
                    even.await();
                }
                System.out.println("Even : " + start++);
                odd.signal();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    public void printOdd() {
        while (start < end) {
            try {
                lock.lock();
                if (start % 2 != 1) {
                    odd.await();
                }
                System.out.println("Odd : " + start++);
                even.signal();

            } catch (InterruptedException ex) {
                System.out.println(end);
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        OddEvenWithTwoThread work = new OddEvenWithTwoThread(1, 10);
        Thread t1 = new Thread(work::printEven);
        Thread t2 = new Thread(work::printOdd);

        t1.start();
        t2.start();
    }
}
