package com.java.queue;

import java.util.*;

public class MyPriorityQueue {

	public static void main(String[] args) {

		Queue<Integer> pq =  new PriorityQueue(Collections.reverseOrder()); // max heap, by default it is min heap

		int[] arr = { 2, 7, 4, 1, 8, 1 };
		
		for (int a : arr) {
			pq.add(a);
		}

		while (pq.size() > 1) {
			int y = pq.poll();
			int x = pq.poll();

			if (x != y) {
				pq.add(y - x);
			}
		}

		System.out.println(pq.peek());
		
		
		// FIFO Queue
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		q.poll();
		q.peek();
		
		// FIFO + LIFO Queue : Double Ended Queue
		Deque<Integer> deq = new ArrayDeque<>();
		deq.offer(1);
		deq.push(3);
		deq.pop();
		deq.poll();
		deq.peek();
		

	}

}
