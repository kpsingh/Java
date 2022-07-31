package com.java.util.concurrent;

public class E1_OddEvenByWaitNotify {

	public static void main(String[] args) {
		Print2 p = new Print2();

		Thread even = new Thread(() -> p.printEven());

		Thread odd = new Thread(() -> p.printOdd());

		even.start();
		odd.start();
	}

}

class Print2 {

	public synchronized void printEven() {

		for (int i = 2; i <= 10; i += 2) {

			try {
				this.wait();
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Even : " + i);

			this.notify();
		}

	}

	public synchronized void printOdd() {

		for (int i = 1; i < 10; i += 2) {

			System.out.println("Odd : " + i);

			this.notify();

			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}