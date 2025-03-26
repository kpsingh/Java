package com.java.stack;

/*
Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
NOTE:
All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Pair> stack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Pair(x, x));
        } else {
            stack.push(new Pair(x, Math.min(x, stack.peek().min)));
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.size() > 0 ? stack.peek().value : -1;
    }

    public int getMin() {
        return stack.size() > 0 ? stack.peek().min : -1;
    }


    // test the min Function

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(7);
        stack.push(6);
        stack.push(1);
        stack.push(8);

        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }
}


class Pair {
    int value;
    int min;

    public Pair(int val, int min) {
        this.min = min;
        this.value = val;
    }
}
