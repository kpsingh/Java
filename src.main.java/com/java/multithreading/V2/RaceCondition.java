package com.java.multithreading.V2;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		Work work = new Work();

		Runnable runnable = () -> {
			for (int i = 1; i <= 1000; i++) {
				work.incremetnValue();
			}
		};

		Thread[] threads = new Thread[10];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(runnable);
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}

		System.out.println("Value of Work : " + work.getValue());

	}

}
