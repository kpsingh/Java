package com.java.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * In this class we'll explore how to play around the Future object which being
 * returned from the call method of Callable interface.
 *
 * We'll have a list of Callable Jobs and get the list of Future for each job.
 * We'll see the value of each job of the Future object and explore them
 * further.
 *
 *
 *
 */

public class C_ExecutorServiceWithCallableAndFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(5);

		/**
		 * 1. Create a list of Job/Task which need to submitted and initialize with all
		 * jobs
		 * 
		 * 2. Create a list to hold returned Future object.
		 * 
		 */

		List<Task3> jobList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			jobList.add(new Task3());
		}

		List<Future<Integer>> futureList = new ArrayList<>();

		for (Task3 t : jobList) {

			Future<Integer> future = service.submit(t);
			futureList.add(future);
		}

		for (Future<Integer> f : futureList) {

			System.out.println(f.get());
		}

		service.shutdown();

	}

}

class Task3 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		// do eligibility check operation and return the outcome

		return new Random().nextInt(10);
	}

}