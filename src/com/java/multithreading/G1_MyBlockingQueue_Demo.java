package com.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class G1_MyBlockingQueue_Demo {

	static int number = 1;

	public static void main(String[] args) {

		G_MyBlockingQueue<Integer> queue = new G_MyBlockingQueue<>(5);
		ExecutorService service = Executors.newFixedThreadPool(2);

		Runnable producer = () -> {

			while (true) {
				try {

					System.out.println("Produced : " + number);
					queue.put(number++);
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};

		Runnable consumer = () -> {

			while (true) {
				try {

					System.out.println("Consumed : " + queue.take());

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
