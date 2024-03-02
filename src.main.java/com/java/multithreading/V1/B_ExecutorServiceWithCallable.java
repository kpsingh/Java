package com.java.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B_ExecutorServiceWithCallable {

	public static void main(String[] args) {

		// create the thread pool

		ExecutorService service = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 100; i++) {

			service.submit(new Task1());// typically this will return the Future<Integer> object
		}

		service.shutdown();

	}

}

class Task1 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		return new Random().nextInt();

	}

}