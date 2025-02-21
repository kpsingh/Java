package com.test;

public class Test{

    static{

        System.out.println("Hello Staic");

    }

    Test(){

        System.out.println("Hello constructor");

    }

    {

        System.out.println("Hello block");

    }

    public static void main(String[] args){

        Test t = new Test();
    }

}
