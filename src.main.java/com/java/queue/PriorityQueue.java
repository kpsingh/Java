package com.java.queue;

import java.util.Collections;
import java.util.Queue;

public class PriorityQueue {

	public static void main(String[] args) {

		Queue<Integer> pq = new java.util.PriorityQueue<>(Collections.reverseOrder()); // max heap

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

	}

}
