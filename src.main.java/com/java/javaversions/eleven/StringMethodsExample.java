package com.java.javaversions.eleven;

public class StringMethodsExample {
    public static void main(String[] args) {
        String str = "   Hello Java 11   ";

        System.out.println(str.isBlank());        // false
        System.out.println(str.strip());          // "Hello Java 11"
        System.out.println(str.stripLeading());   // "Hello Java 11   "
        System.out.println(str.stripTrailing());  // "   Hello Java 11"
        System.out.println("Java\n11".lines().count());  // 2
        System.out.println("Hi ".repeat(3));      // "Hi Hi Hi "

        System.out.println("  ".isBlank()); // true
        System.out.println("  ".length()); // 2
    }
}

