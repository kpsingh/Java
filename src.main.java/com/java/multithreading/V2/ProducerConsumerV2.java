package com.java.multithreading.V2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerV2 {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		Lock lock = new ReentrantLock();

	}

	class Consumer implements Callable<String> {
		List<Integer> list;
		Lock lock;

		public Consumer(List<Integer> list, Lock lock) {
			this.list = list;
			this.lock = lock;
		}

		public String call() throws InterruptedException {
			int count = 1;

			while (count++ < 50) {
				try {
					lock.lock();
					if (list.isEmpty()) {
						// await
					}
					list.remove(list.size() - 1);
					// signal

				} finally {
					lock.unlock();
				}
			}

			return "Consumed : " + (count - 1);

		}

	}

	class Producer implements Callable<String> {
		List<Integer> list;
		Lock lock;

		public Producer(List<Integer> list, Lock lock) {
			this.list = list;
			this.lock = lock;
		}

		public String call() throws InterruptedException {
			int count = 1;

			while (count++ < 50) {
				try {
					lock.lock();
					if (list.size() >= 50) {
						// await
					}
					list.add(1);
					// signal

				} finally {
					lock.unlock();
				}
			}

			return "Produced : " + (count - 1);

		}

	}
}
