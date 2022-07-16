package com.java.multithreading.adv;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueExample {

	public static void main(String[] args) {

		MyBlockingQueue<Integer> q = new MyBlockingQueue<>(1);

		Runnable producer = () -> {
			int i = 1;
			while (true) {
				System.out.println("Produced : " + i);
				q.put(i++);
			}
		};

		Runnable consumer = () -> {
			while (true) {
				System.out.println("Consumed : " + q.take());
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

/*
 * Self made Blocking queue instead of using the Java BlockingQueue
 * 
 */

class MyBlockingQueue<E> {

	private Queue<E> queue;
	private int max;

	private ReentrantLock lock;

	private Condition notFull;
	private Condition notEmpty;

	public MyBlockingQueue(int size) {

		this.max = size;
		queue = new LinkedList<>();
		lock = new ReentrantLock(true);

		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
	}

	public void put(E e) {

		lock.lock();

		try {

			while (queue.size() == max) {
				// Block the queue if its full
				try {
					notFull.await();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			queue.add(e);

			notEmpty.signalAll();

		} finally {

			lock.unlock();
		}

	}

	public E take() {

		lock.lock();

		try {

			while (queue.size() == 0) {

				try {
					notEmpty.await();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			E item = queue.remove();

			notFull.signalAll();

			return item;

		} finally {

			lock.unlock();
		}

	}
}
