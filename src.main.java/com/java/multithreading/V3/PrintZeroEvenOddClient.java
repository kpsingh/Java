package com.java.multithreading.V3;

import java.util.Set;
import java.util.concurrent.Semaphore;

public class PrintZeroEvenOddClient {
    public static void main(String[] args) {
        PrintZeroEvenOdd print = new PrintZeroEvenOdd(40);
        Thread t1 = new Thread(print::zero);
        Thread t2 = new Thread(print::even);
        Thread t3 = new Thread(print::odd);

        t1.start();
        t2.start();
        t3.start();


    }
}

class PrintZeroEvenOdd {
    Semaphore zero;
    Semaphore even;
    Semaphore odd;
    boolean isOdd;
    int i = 0;
    private int n;

    public PrintZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        even = new Semaphore(0);
        odd = new Semaphore(0);
        isOdd = true;
        i = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() {
        try {
            while (i <= n) {
                zero.acquire();
                if (i <= n) System.out.print(0);
                if (isOdd) {
                    odd.release();
                } else {
                    even.release();
                }
                isOdd = !isOdd;
            }

        } catch (InterruptedException e) {
        }

    }

    public void even() {
        try {
            while (i <= n) {
                even.acquire();
                if (i <= n) System.out.print(i++);
                zero.release();
            }

        } catch (InterruptedException e) {
        }

    }

    public void odd() {
        try {
            while (i <= n) {
                odd.acquire();
                if (i <= n) System.out.print(i++);
                zero.release();
            }

        } catch (InterruptedException e) {
        }

    }
}