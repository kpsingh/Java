package com.test.leetcode;

public class MyThread  implements  Runnable{

    Thread t;
    MyThread(){
        t = new Thread(this, "My Thread");
        t.start();
    }
    @Override
    public void run() {
        System.out.println(t.getName());

    }

    public static void main(String[] args) {
        new MyThread();
    }
}
