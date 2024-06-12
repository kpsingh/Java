package com.java.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DEQueueExample {
	public static void main(String[] args) {

		Deque<Integer> stack = new ArrayDeque<>();
		stack.add(1);
		stack.add(3);
		stack.add(-1);
		stack.add(-3);
		stack.add(5);
		stack.add(3);
		stack.add(6);
		stack.add(17);
		System.out.println(stack);
		System.out.println("Peek : " + stack.peek());
		System.out.println("PeekFirst : " + stack.peekFirst());
		System.out.println("PeekLast : " + stack.peekLast());

		System.out.println(" \n");

		System.out.println("Poll : " + stack.poll());
		System.out.println("Poll First : " + stack.pollFirst());
		System.out.println("Poll Last : " + stack.pollLast());

		System.out.println(" \n");

		System.out.println(stack);

		stack.add(10);
		stack.addFirst(20);
		stack.addLast(30);

		System.out.println(stack);
		
		

	}

}
