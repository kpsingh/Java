package com.java.javaversions.eleven;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        Optional<String> optional = Optional.of("Hello, Java 11!");

        // orElseThrow()
        System.out.println(optional.orElseThrow()); // "Hello, Java 11!"

        // isEmpty()
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isEmpty()); // true
      //  System.out.println(emptyOptional.orElseThrow()); // "Hello, Java 11!"


        Optional<String> testOptional = Optional.of("Hello Krishna");
        System.out.println(testOptional.isPresent());
       // System.out.println(testOptional.orElseThrow());
        System.out.println(testOptional.orElseThrow(IllegalArgumentException::new));
        System.out.println(testOptional.isEmpty());

    }
}
