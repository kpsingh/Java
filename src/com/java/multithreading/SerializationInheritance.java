package com.java.multithreading;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//superclass A - implementing Serializable interface
class X implements Serializable {
	int i;

	// parameterized constructor
	public X(int i) {
		this.i = i;
	}

}

//subclass B - B class doesn't implement Serializable interface.
class Y extends X {
	int j;

	// parameterized constructor
	public Y(int i, int j) {
		super(i);
		this.j = j;
	}
}

public class SerializationInheritance {

	public static void main(String[] args) throws Exception {

		Y y1 = new Y(0, 0);

		System.out.println("i = " + y1.i);
		System.out.println("j = " + y1.j);

		/* Serializing B's(subclass) object */

		// Saving of object in a file
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// Method for serialization of B's class object
		oos.writeObject(y1);

		// closing streams
		oos.close();
		fos.close();

		System.out.println("Object has been serialized");

		/* De-Serializing B's(subclass) object */

		// Reading the object from a file
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);

		// Method for de-serialization of B's class object
		Y b2 = (Y) ois.readObject();

		// closing streams
		ois.close();
		fis.close();

		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}
}