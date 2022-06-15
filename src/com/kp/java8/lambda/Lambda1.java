package com.kp.java8.lambda;

@FunctionalInterface
interface DemoFunctional {

	public void test(int i);
}

public class Lambda1 {

	public static void main(String[] args) {
		
		
		DemoFunctional f1 = (i) -> System.out.println("Hello from Functional interface : " +  i);
		f1.test(5);

	}

}
