package com.java.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenUsingLockAndCondition {

	public static void main(String[] args) {

		Display2 d = new Display2();

		Thread t1 = new Thread(() -> d.printEven());
		Thread t2 = new Thread(() -> d.printOdd());

		t1.start();
		t2.start();

	}

}

class Display2 {

	ReentrantLock lock = new ReentrantLock(true);
	Condition even = lock.newCondition();
	Condition odd = lock.newCondition();

	int i = 1;

	public void printEven() {

		lock.lock();

		while (i <= 10) {

			try {
				if (i % 2 != 0) {
					even.await();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Even : " + i++);

			odd.signalAll();

		}

		lock.unlock();

	}

	public void printOdd() {

		lock.lock();

		while (i <= 10) {

			System.out.println("Odd : " + i++);

			even.signalAll();

			try {
				odd.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		lock.lock();
	}
}