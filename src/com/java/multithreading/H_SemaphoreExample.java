package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * https://www.youtube.com/watch?v=shH38znT_sQ&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=16
 * 
 * 
 * It is used to restrict the maximum number of threads that can access a
 * resource at a given time. If more threads come then they have to wait to
 * release the semaphore from the already running thread. If N = 3, then at any
 * given moment a maximum of 3 threads can access a resource and other threads
 * have to wait.
 * 
 */

public class H_SemaphoreExample {
	public static void main(String[] args) throws InterruptedException {

		Semaphore semaphore = new Semaphore(3); // max 3 permits available

		ExecutorService service = Executors.newFixedThreadPool(10);

		/**
		 * Populate the 100 jobs and let thread pool of 10 execute. Even though 10
		 * threads are available in pool at a time only 4 thread will able to execute
		 * I/O or HTTP call as specified in run method of Job
		 */
		for (int i = 0; i < 100; i++) {

			service.execute(new Task6(semaphore));
		}

		service.shutdown();

	}

}

class Task6 implements Runnable {

	private Semaphore semaphore;

	public Task6(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {

		// some processing

		try {
			/**
			 * Acquires a permit from this semaphore, blocking until one is available, or
			 * the thread is interrupted.
			 * 
			 * Acquires a permit, if one is available and returns immediately, reducing the
			 * number of available permits by one.
			 */

			semaphore.acquire();

			// I/O call or HTTP call or any other processing. At a time only 3 threads will
			// run
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		finally {
			/**
			 * Releases a permit, returning it to the semaphore.
			 * 
			 * Releases a permit, increasing the number of available permits by one. If any
			 * threads are trying to acquire a permit, then one is selected and given the
			 * permit that was just released. That thread is (re)enabled for thread
			 * scheduling purposes.
			 */
			semaphore.release(); // release the permit
		}

	}

}