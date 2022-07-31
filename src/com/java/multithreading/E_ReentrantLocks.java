package com.java.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class E_ReentrantLocks {

	public static void main(String[] args) {

		Print p = new Print();

		Thread t1 = new Thread(() -> p.odd());

		Thread t2 = new Thread(() -> p.even());

		t1.start();
		t2.start();

	}

}

class Print {

	private volatile int number;
	ReentrantLock lock;
	Condition even;
	Condition odd;

	public Print() {
		this.number = 1;
		lock = new ReentrantLock();
		even = lock.newCondition();
		odd = lock.newCondition();
	}

	public void even() {

		try {

			lock.lock();

			while (number < 10) {

				if (number % 2 != 0) {

					/*
					 * if number is ODD then wait for signal when it becomes even
					 */
					even.await();
				}

				/*
				 * if number is even then print and make it odd by incrementing and signal that
				 * is is odd now
				 * 
				 */

				System.out.println(Thread.currentThread().getName() + " : " + number++);

				odd.signalAll();

			}
		} catch (InterruptedException e) {

			e.getMessage();

		} finally {

			lock.unlock();
		}

	}

	public void odd() {

		try {

			lock.lock();

			while (number < 10) {

				if (number % 2 == 0) {

					/*
					 * if number is EVEN then wait for signal when it becomes ODD
					 */
					odd.await();

				}
				/*
				 * if number is ODD then print and make it even by incrementing and signal that
				 * is is even now
				 */

				System.out.println(Thread.currentThread().getName() + " : " + number++);

				even.signalAll();

			}
		} catch (InterruptedException e) {

			e.getMessage();

		} finally {

			lock.unlock();
		}

	}
}