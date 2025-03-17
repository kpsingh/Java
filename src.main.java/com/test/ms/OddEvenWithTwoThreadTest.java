package com.test.ms;

import org.junit.Test;

public class OddEvenWithTwoThreadTest {

    @Test
    public void printOddEven() {
        OddEvenWithTwoThread work = new OddEvenWithTwoThread(1, 10);
        Thread t1 = new Thread(work::printEven);
        Thread t2 = new Thread(work::printOdd);

        t1.start();
        t2.start();


    }
}
