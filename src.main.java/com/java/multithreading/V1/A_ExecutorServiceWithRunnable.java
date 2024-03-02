package com.java.multithreading.V1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this class will demonstrate how we can use the executor service for running
 * the runnable job's
 *
 */
public class A_ExecutorServiceWithRunnable {

	volatile static int count = 0;

	public static void main(String[] args) {

		// create a thread pool

		ExecutorService service = Executors.newFixedThreadPool(10);

		// Submit the task/job to the thread pool to execute it. Let say I have 100 Jobs to run

		for (int i = 0; i < 100; i++) {
			service.execute(new Task(count++)); // Either we can use execute or submit method for Runnable type
		}

		System.out.println("Thread Name : " + Thread.currentThread().getName());
		System.out.println();

		service.shutdown();

	}
}

class Task implements Runnable {

	int taskNumber;

	public Task(int taskNumber) {
		this.taskNumber = taskNumber;
	}

	@Override
	public void run() {

		System.out.println("Task : " + taskNumber + " by Thread  : " + Thread.currentThread().getName());
	}

}