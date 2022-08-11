package com.java.exceptions;

/**
 * We can handle the multiple exceptions in single catch block
 * 
 * In Multi catch we don't pass any exception which are related to each other...
 * for Example if parent and child exceptions... ex ArithmeticException is child
 * of Exception so if we pass both then compiler not allow since if Exception is
 * there then why ArithmeticException needed ?
 * 
 * 
 * Catch (ArithmeticException | NullPointerException | ClassCastException |
 * Exception e) : is not allowed
 *
 * The exception ArithmeticException is already caught by the alternative
 * Exception The exception NullPointerException is already caught by the
 * alternative Exception The exception ClassCastException is already caught by
 * the alternative Exception
 *
 * 
 * 
 * 
 *
 */
public class MultiCatch {
	public static void main(String[] args) {
		try {

		    System.out.println(10 / 0);

			String s = null;

			System.out.println(s.length());

		} catch (ArithmeticException | NullPointerException | ClassCastException e) {

			System.out.println(e);

			System.out.println(e.getMessage());

		}

	}
}
