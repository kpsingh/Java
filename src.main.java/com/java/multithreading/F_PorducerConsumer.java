package com.java.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class F_PorducerConsumer {

	static int a = 1;

	public static void main(String[] args) {

		BlockingQueue<Integer> q = new ArrayBlockingQueue<>(5);

		ExecutorService service = Executors.newFixedThreadPool(2);

		Runnable producer = () -> {
			while (a < 10) {
				try {
					q.put(a++);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		Runnable consumer = () -> {
			while (a < 10) {
				try {
					System.out.println(q.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		Runnable[] jobs = { producer, consumer };

		for (Runnable r : jobs) {
			service.execute(r);
		}

		service.shutdown();

	}

}
