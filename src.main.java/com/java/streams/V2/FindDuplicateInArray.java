package com.java.streams.V2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInArray {
    public static void main(String[] args) {

        // Sample List with duplicates
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3, 6, 2, 7, 8, 9, 5);

        // Find duplicates using Stream API
        Set<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting())) // Group by number, count occurrences
                .entrySet().stream() // Convert map entries to stream
                .filter(entry -> entry.getValue() > 1) // Filter entries with count > 1 (i.e., duplicates)
                .map(Map.Entry::getKey) // Extract the keys (numbers)
                .collect(Collectors.toSet()); // Collect duplicates into a Set

        // Print the duplicates
        System.out.println("Duplicate elements: " + duplicates);

        String[] names = {"Krishna", "Ram", "Mohan", "Ram"};
        Set<String> nameDup = Arrays.stream(names).collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(word -> word.getKey()).collect(Collectors.toSet());

        System.out.println("Duplicate names: " + nameDup);


    }
}
