package com.java.streams.V2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFAQ_V1 {
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
        boolean hasPrime = Arrays.asList(5, 6, 7, 8, 9).stream().anyMatch(StreamFAQ_V1::isPrime);
        System.out.println("hasPrime: " + hasPrime);
        // Finding All Prime Numbers
        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 37, 5, 7, 40);
        List<Integer> listOfPrimeNum = numbers.stream().filter(StreamFAQ_V1::isPrime).collect(Collectors.toList());
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

        // Given a list of strings, find the frequency of each word using Java streams:
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // or
        Map<String, Long> wordsCount = words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(wordsCount);

        // Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> list = Arrays.asList(10, 25, 30, 45, 60, 75, 80);
        Map<Boolean, List<Integer>> partitioned = list.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0));
        System.out.println(partitioned.get(true)); // even list
        System.out.println(partitioned.get(false)); // odd list

        // Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> intList = Arrays.asList(10,5,514,19,114,217,152);
        intList.stream().map(String::valueOf).filter(s -> s.startsWith("1")).forEach(System.out::println);

        // find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        // Find duplicate elements
        Set<Integer> duplicates = myList.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting())) // Count occurrences
                .entrySet().stream() // Convert to Stream
                .filter(entry -> entry.getValue() > 1) // Keep only duplicates
                .map(Map.Entry::getKey) // Extract duplicate elements
                .collect(Collectors.toSet()); // Collect to Set to avoid duplicates

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
