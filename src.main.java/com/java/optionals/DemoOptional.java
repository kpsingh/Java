package com.java.optionals;

import java.util.Optional;
/*
https://www.oracle.com/technical-resources/articles/java/java8-optional.html

 */

public class DemoOptional {
    public static void main(String[] args) {

        // Optional.empty();
        // Optional.of("zyx");
        // Optional.ofNullable("");
        Optional<String> optional = Optional.empty();


        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Empty Optional");
        }


        System.out.println(optional.orElse("Its Empty Optional"));

        optional = Optional.of("Hello");

        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Not Present");
        }

        // orElse
        optional = Optional.empty();
        System.out.println("The value of optional is : " + optional.orElse("Optional value is empty"));

        User user = new User();
        user.setName("Krishna");

        //
        Optional<Address> address = user.getAddress();


        // isPresent
        if (address.isPresent()) {
            System.out.println(address.get().getLane());
        } else {
            System.out.println("Not Present");
        }
        // ifPresent
        address.ifPresent(System.out::println);


    }
}


