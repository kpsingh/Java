package com.java.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DEQueueExample {
	public static void main(String[] args) {

		Deque<Integer> deq = new ArrayDeque<>();
		deq.add(1);
		deq.add(3);
		deq.add(-1);
		deq.add(-3);
		deq.add(5);
		deq.add(3);
		deq.add(6);
		deq.add(17);
		System.out.println(deq);
		System.out.println("Peek : " + deq.peek());
		System.out.println("PeekFirst : " + deq.peekFirst());
		System.out.println("PeekLast : " + deq.peekLast());

		System.out.println(" \n");

		System.out.println("Poll : " + deq.poll());
		System.out.println("Poll First : " + deq.pollFirst());
		System.out.println("Poll Last : " + deq.pollLast());

		System.out.println(" \n");

		System.out.println(deq);

		deq.offer(10);
		deq.offerFirst(20);
		deq.offerLast(30);

		System.out.println(deq);
		
		

	}

}
