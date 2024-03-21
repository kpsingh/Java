package com.java.multithreading.V3.addersubs.methodsynch;

public class Count {
    private  int value;

    public Count(){
        this.value = 0;
    }
    public synchronized void add(int val){
        this.value += val;
    }

    public synchronized void subtract(int val){
        this.value -= val;
    }

    public int getCount(){
        return this.value;
    }
}
