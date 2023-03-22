package com.java.lambda;

public class Test1 {
	
	public static void main(String args[]) {
		
		
		/*
		 * IN typical case we need to create the instance of implementation class and then call the method by
		 * that instance but by using the lambda expression we can call it directly.
		 */
		
		Interf f1 = () -> System.out.println("hello lambda...");
		f1.m1();
		
	}
	
	

}

/*
 * We don't have to write the implementation calss if we can use the Lambda expression in order to implement.
 */
interface Interf {
	public void m1();
}