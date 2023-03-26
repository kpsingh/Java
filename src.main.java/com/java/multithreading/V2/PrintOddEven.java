package com.java.multithreading.V2;

public class PrintOddEven {

	public static void main(String[] args) {
		
		Print print = new Print(1);

		Runnable oddTask = () -> {
			try {
				print.printOdd();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		};

		Runnable evenTask = () -> {
			try {
				print.printEven();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		};

		Thread t1 = new Thread(oddTask);
		Thread t2 = new Thread(evenTask);

		t1.start();
		t2.start();

	}
}

class Print {

	int i;

	Object key = new Object();

	public Print(int i) {
		this.i = i;
	}

	public void printOdd() throws InterruptedException {

		while (i < 10) {

			synchronized (key) {

				if (i % 2 == 0) {
					key.wait();
				}

				System.out.println("Odd : " + i++);
				Thread.sleep(1000);
				
				key.notify();
			}

		}

	}

	public void printEven() throws InterruptedException {

		while (i < 10) {

			synchronized (key) {

				if (i % 2 == 1) {
					key.wait();
				}

				System.out.println("Even : " + i++);
				Thread.sleep(1000);

				key.notify();
			}

		}

	}
}