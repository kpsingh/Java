package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorExample1 {
	public static void main(String[] args) {

		Print3 print = new Print3();

		Runnable[] jobs = { () -> print.printEven(), () -> print.printOdd() };

		ExecutorService service = Executors.newFixedThreadPool(2);
		for (Runnable job : jobs) {
			service.submit(job);
		}

		service.shutdown();

	}

}

class Print3 {

	Lock lock = new ReentrantLock(true);

	public void printEven() {

		for (int i = 2; i <= 10; i += 2) {

			lock.lock();

			System.out.println("Even : " + i);

			lock.unlock();

		}
	}

	public void printOdd() {

		for (int i = 1; i < 10; i += 2) {

			lock.lock();

			System.out.println("Odd : " + i);

			lock.unlock();

		}

	}
}
