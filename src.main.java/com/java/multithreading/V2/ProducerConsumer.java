package com.java.multithreading.V2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(2);

		Print1 p = new Print1(1);

		service.execute(() -> p.printEven());
		service.execute(() -> p.printOdd());

		service.shutdown();

	}

}

 class Print1 {

	private int count;

	Lock lock = new ReentrantLock();
	Condition isEven = lock.newCondition();
	Condition isOdd = lock.newCondition();

	public Print1(int count) {
		this.count = count;
	}

	public void printEven() {

		while (count < 5) {

			try {
				lock.lock();

				if (count % 2 != 0) {
					isEven.await();
				}
				System.out.println("Even : " + count++);
				isOdd.signal();

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}

		System.out.println("Finished producing Even Number");
	}

	public void printOdd() {

		while (count < 5) {

			try {
				lock.lock();

				if (count % 2 == 0) {
					isOdd.await();
				}

				System.out.println("Odd : " + count++);
				isEven.signal();

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}

		System.out.println("Finished producing Odd Number");
	}
}