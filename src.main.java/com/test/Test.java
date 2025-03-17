package com.test;

public class Test{

    static{

        System.out.println("Hello Staic"); // 1

    }

    Test(){

        System.out.println("Hello constructor"); // 3

    }

    {

        System.out.println("Hello block"); // 2

    }

    public static void main(String[] args){

        Test t = new Test();
    }

}
