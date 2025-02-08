package com.java.streams.V2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestions {
    public static void main(String[] args) {
        ///Q. Find the longest string in a list of strings using Java streams:
        List<String> names = Arrays.asList("KP", "Modi", "Ramayan", "Mahabharat");
        names.stream().sorted((s1, s2) -> s2.length() - s1.length()).limit(1).forEach(System.out::println);
        names.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        names.stream().min(Comparator.comparing(String::length)).ifPresent(System.out::println);
        names.stream().max((s1, s2) -> s1.length() - s2.length()).ifPresent(System.out::println);

        // Calculate the average age of a list of Person objects using Java streams:
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        persons.stream().mapToInt(Person::getAge).average().orElse(0);
        persons.stream().mapToInt(Person::getAge).average().ifPresent(System.out::println);

        //Check if a list of integers contains a prime number using Java streams:
        boolean hasPrime = Arrays.asList(5, 6, 7, 8, 9).stream().anyMatch(StreamQuestions::isPrime);
        System.out.println("hasPrime: " + hasPrime);
        // Finding All Prime Numbers
        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 37,5,7, 40);
        List<Integer> listOfPrimeNum = numbers.stream().filter(StreamQuestions::isPrime).collect(Collectors.toList());
        System.out.println(listOfPrimeNum);


    }

    public static boolean isPrime(int n) {
        if (n < 2) return false; // not a prime
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
