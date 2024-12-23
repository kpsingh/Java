package com.test.infosys;

public class TestStackMin {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(8);
        stack.push(16);
        stack.push(21);
        stack.push(78);
        stack.push(5);
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(9);


        System.out.println("Value at top: " + stack.peek());
        System.out.println("Min Value: " + stack.min());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Min Value: " + stack.min());




    }
}
