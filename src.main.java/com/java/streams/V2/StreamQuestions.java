package com.java.streams.V2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 37, 5, 7, 40);
        List<Integer> listOfPrimeNum = numbers.stream().filter(StreamQuestions::isPrime).collect(Collectors.toList());
        System.out.println(listOfPrimeNum);

        // Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> sortedList = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        // Find the intersection of two lists using Java streams:
        list1 = Arrays.asList(1, 3, 5, 7, 9);
        list2 = Arrays.asList(2, 4, 5, 9);
        List<Integer> intersection = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(intersection);

        // Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        numbersWithDuplicates = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(numbersWithDuplicates);

        // Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> sumByDate = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
        System.out.println(sumByDate);
        // add the total transaction
        Integer totalAmount = transactions.stream().collect(Collectors.summingInt(Transaction::getAmount));
        System.out.println(totalAmount);

        int sum = transactions.stream().mapToInt(Transaction::getAmount).sum();
        System.out.println(sum);

        // Find the kth smallest element in an array using Java streams:
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        // skipp k-1
        int kthSmallest = IntStream.of(array).sorted().skip(4).findFirst().orElse(-1);
        System.out.println(kthSmallest);


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
