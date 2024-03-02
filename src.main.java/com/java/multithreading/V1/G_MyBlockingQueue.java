package com.java.multithreading.V1;

/**
 * 
 * https://www.youtube.com/watch?v=UOr9kMCCa5g&list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6&index=18
 * 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class G_MyBlockingQueue<E> {

	private Queue<E> queue;
	private int max;
	private Lock lock;

	Condition notFull;
	Condition notEmpty;

	public G_MyBlockingQueue(int size) {
		this.queue = new LinkedList<>();
		this.max = size;
		this.lock = new ReentrantLock();
		this.notEmpty = lock.newCondition();
		this.notFull = lock.newCondition();

	}

	public void put(E a) throws InterruptedException {

		lock.lock();
		try {

			while (queue.size() == max) {
				notFull.await(); // Q is full, wait for notFull signal
			}

			queue.add(a); // element added to the Q
			notEmpty.signalAll(); // Signal that Q is notEmpty

		} finally {
			lock.unlock();
		}

	}

	public E take() throws InterruptedException {

		lock.lock();
		try {

			while (queue.size() == 0) {
				notEmpty.await(); // Q is empty, wait for notEmpty signal
			}

			E item = queue.remove(); // element removed from the Q
			notFull.signalAll(); // signal that Q is notFull
			return item;

		} finally {
			lock.unlock();

		}

	}

}
