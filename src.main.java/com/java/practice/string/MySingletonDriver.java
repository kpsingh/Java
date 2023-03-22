package com.java.practice.string;

/*
https://www.baeldung.com/java-singleton
https://www.geeksforgeeks.org/singleton-class-java/

A private constructor
A static field containing its only instance
A static factory method for obtaining the instance
 */

public class MySingletonDriver {

	public static void main(String[] args) {

	}

}

/*
 * We can define the Singleton class in such a way that only one instance will
 * be get created.
 * 
 * 1 . A private constructor so that no one can create the instance explicitly 2
 * . A private instance variable which get returned from the getter. 3 . A
 * public getter method to return the instance. If not created then create the
 * instance otherwise returned the already created one.
 */

class MySingleton {

	private static MySingleton instanace;

	private MySingleton() {

	}

	/*
	 * Eager initialization -
	 * 
	 * Here we have created instance of singleton in static initializer. JVM
	 * executes static initializer when the class is loaded and hence this is
	 * guaranteed to be thread safe. Use this method only when your singleton class
	 * is light and is used throughout the execution of your program.
	 * 
	 * class Singleton { private static Singleton obj = new Singleton();
	 * 
	 * private Singleton() {}
	 * 
	 * public static Singleton getInstance() { return obj; } }
	 * 
	 * 
	 * 
	 */

	// Below three methods come under lazy initialization.

	// Method one - not thread safe
	public static MySingleton getInstance1() {

		if (instanace == null) {
			instanace = new MySingleton();
		}
		return instanace;

	}

	// Method 2 - Tread Safe but not efficient

	public static synchronized  MySingleton getInstance2() {

		if (instanace == null) {
			instanace = new MySingleton();
		}

		return instanace;
	}

	// Method 3 - Thread safe and efficient. Double checking locking

	public static MySingleton getInstace3() {

		if (instanace == null) {

			synchronized (MySingleton.class) {

				if (instanace == null) {

					instanace = new MySingleton();
				}
			}

		}

		return instanace;

	}

}