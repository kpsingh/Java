package com.test.infosys;/*
Design a stack which, in addition to push and pop, has a function
min () which returns the minimum element of the stack at a
given point of time. The push (), pop () and min () functions should all operate in O(1) time.
 */
public class CustomStack {
    private Pair[] container;
    private int top;
    private int size;

    public CustomStack() {
        container = new Pair[10];
        top = -1;
        size = 0;
    }
    public void push(int val) {
        if (size == container.length - 1) {
            // usually we double down the container size Stack is full
            return;
        }
        Pair pair = null;
        if (size == 0) {
            pair = new Pair(val, val);
        } else {
            pair = new Pair(val, Math.min(val, container[top].min));
        }
        container[++top] = pair;
        size++;
    }
    public int pop() {
        if (size == 0) {
            return -1; // Stack is Empty
        }
        size--;
        return container[top--].val;
    }
    public int min() {
        return container[top].min;
    }
    public int peek() {
        return container[top].val;
    }
}


class Pair {
    int val;
    int min;

    public Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}