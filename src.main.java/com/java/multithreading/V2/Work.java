package com.java.multithreading.V2;

public class Work {

	// if this lock onject is not used then the valye may not be correct incremented
	// and race condition can ocured

	private Object key = new Object();

	private int value;

	public Work() {
		this.value = 0;
	}

	public int getValue() {
		return this.value;
	}

	public void incremetnValue() {
		// if we removed this synchronized block then race condition will happen
		synchronized (key) {
			this.value++;
		}

	}

}
