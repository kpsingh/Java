package com.java.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * https://www.youtube.com/watch?v=nDE1bsy10Yo&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=19
 * 
 * 
 * In this class we'll explore how to play around the Future object which being
 * returned from the call method of Callable interface.
 *
 * Let say we have 10 jobs to be get it done, we'll span the 10 threads and run
 * the job. Once all job get finished then we'll see the result of each job to
 * decide next step.
 * 
 * Ex: - Let say we want to check if customer is eligible for WalthAccount or
 * not. We'll run all the eligibility check asynchronous and validate the result
 * of each check, is any check fails then we'll stop the journey and send the
 * user back the message which eligibility got failed.
 *
 * We'll Implement Scatter Gather pattern to solve this problem.
 * 
 * Initially each eligibility check were performed one by one but after this all
 * check can be performed parallel and we'll collect the result of each and then
 * validate if customer is allowed or not.
 *
 */

public class D_ScatterGatherWithCountDownLatch {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(5);

		// Let suppose we have N task. Assume N = 3

		CountDownLatch latch = new CountDownLatch(3);// assuming N eligibility task

		List<IEligibility> list = populateTaskList(latch);

		// to hold the Future for each task submitted

		List<Future<EligibilityResponse>> futureList = new ArrayList<>();

		for (IEligibility task : list) {
			Future<EligibilityResponse> future = service.submit(task);
			futureList.add(future);
		}

		// main thread has to wait until the latch has counted down to zero == implied
		// all job got completed
		latch.await();

		service.shutdown(); // best practice to use in try and finally. avoiding now for simplicity

		// At this point : now all the task has been completed hence see the eligibility
		// result and if fails then return the journey

		for (Future<EligibilityResponse> f : futureList) {

			EligibilityResponse result = f.get();

			// check the result of each task and if any result is not eligible then return/
			// throw error

			if (result.notEligible) {
				System.out.println(result.errorCode);
				return;
			}

		}
		// if all eligibility passes then continue with the account opening journey

	}

	private static List<IEligibility> populateTaskList(CountDownLatch latch) {

		List<IEligibility> tasklist = new ArrayList<>();

		tasklist.add(new Eliginbilty_ResidencialAddress(latch));
		tasklist.add(new Eliginbilty_CRSCountry(latch));
		tasklist.add(new Eliginbilty_CountryOfBirth(latch));

		return tasklist;

	}

}

/**
 * Similarly we can have the one class for each eligibility check and implement
 * Callable and have their own eligibility check validation logic in call
 * method. Desired argument for make eligibility check call we can pass the
 * arguments in the constructor of the Eligibility class like customer id, sales
 * context, user context
 *
 */

class Eliginbilty_ResidencialAddress implements IEligibility {

	CountDownLatch latch = null;

	public Eliginbilty_ResidencialAddress(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public EligibilityResponse call() throws Exception {

		// do eligibility check operation and return the outcome true/false
		boolean notEligible = true;

		EligibilityResponse result = new EligibilityResponse(notEligible, 101 + "_You are not resident of UK");
		latch.countDown();
		return result;

	}

}

class Eliginbilty_CRSCountry implements IEligibility {

	CountDownLatch latch = null;

	public Eliginbilty_CRSCountry(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public EligibilityResponse call() throws Exception {

		// do eligibility check operation and return the outcome true/false
		boolean notEligible = false;

		EligibilityResponse result = new EligibilityResponse(notEligible, null);
		latch.countDown();
		return result;

	}

}

class Eliginbilty_CountryOfBirth implements IEligibility {

	CountDownLatch latch = null;

	public Eliginbilty_CountryOfBirth(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public EligibilityResponse call() throws Exception {

		// do eligibility check operation and return the outcome true/false
		boolean notEligible = false;

		EligibilityResponse result = new EligibilityResponse(notEligible, null);
		latch.countDown();
		return result;

	}

}

class EligibilityResponse {
	boolean notEligible;
	String errorCode;

	public EligibilityResponse(boolean isEligible, String errorCode) {
		super();
		this.notEligible = isEligible;
		this.errorCode = errorCode;
	}

}