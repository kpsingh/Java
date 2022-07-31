package com.java.util.concurrent;

import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 
 * https://www.youtube.com/watch?v=nDE1bsy10Yo&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=19
 * 
 * 
 * this is another way to achieve Scatter Gather Patters. Instead of using
 * CountDownLatch and Executor Service we'll use the CompletabelFuture.
 *
 */
public class D_ScatterGatherWithCompletableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		/**
		 * HashSet to hold eligibility result. If set contains the any not eligible then we
		 * can return.
		 * 
		 * For simplicity storing Boolean but in real time store actual
		 * EligibilityResponse.
		 * 
		 */
		HashSet<Boolean> eligibilityResult = new HashSet<>();

		/*
		 * all the N task get executed parallel. We can use the N different task here.
		 * Using same for simplicity
		 */	

		CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task5(eligibilityResult));
		CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task5(eligibilityResult));
		CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task5(eligibilityResult));

		CompletableFuture<Void> allTask = CompletableFuture.allOf(task1, task2, task3);

		// main thread will wait here until all the task get completed.
		allTask.get();

		// all tasks completed and we can check the result to decide further

		if (eligibilityResult.contains(true)) {
			System.out.println("Custoemr is not eligible for AccountOpening Journey !");
			return;
		}

		// otherwise continue with the journey

	}

}

class Task5 implements Runnable {

	HashSet<Boolean> eligibilityResult = null;

	public Task5(HashSet<Boolean> eligibilityResult) {
		this.eligibilityResult = eligibilityResult;
	}

	@Override
	public void run() {

		// do the eligibility check and update the result based on the check result.
		eligibilityResult.add(true);

	}

}