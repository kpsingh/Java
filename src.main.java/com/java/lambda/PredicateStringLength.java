package com.java.lambda;

import java.io.*;
import java.util.function.*;
import java.util.*;


public class PredicateStringLength {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int n = sc.nextInt();

        String[] arr = new String[n];

        System.out.println("Please enter the names");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        System.out.println(Arrays.toString(arr));

        // Print only those names whose length are > 4

        Predicate<String> p = s -> s.length() > 4;

        for (String name : arr) {
            if (p.test(name)) {
                System.out.println(name);
            }
        }

    }
}
