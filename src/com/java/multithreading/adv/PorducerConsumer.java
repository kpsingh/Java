package com.java.multithreading.adv;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PorducerConsumer {

	public static void main(String[] args) {

		BlockingQueue<Integer> q = new ArrayBlockingQueue<>(1);

		Runnable producer = () -> {
			int i = 1;
			while (true) {
				try {
					System.out.println("Produced : " + i);
					Thread.sleep(2000);
					q.put(i++);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable consumer = () -> {
			while (true) {
				try {
					System.out.println("Consumed : " + q.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable[] jobs = { producer, consumer };

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (Runnable job : jobs) {
			executor.submit(job);
		}

		executor.shutdown();

	}

}
