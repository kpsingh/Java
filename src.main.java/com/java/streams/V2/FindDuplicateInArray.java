package com.java.streams.V2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateInArray {
    public static void main(String[] args) {
        String[] names = {"Krishns", "Ram", "Mohan", "Ram"};

        List<String> collect = Arrays.stream(names)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Group by element and count
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Filter elements with count greater than 1
                .map(Map.Entry::getKey) // Extract the keys (the elements)
                .collect(Collectors.toList());// Collect as a list

        System.out.println(collect);

        Integer[] array = {1, 2, 3, 4, 5, 1, 4, 6, 7, 8, 9, 5};

        Map<Integer, Long> groupByMap = Arrays.stream(array).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> nonUnique = groupByMap.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        System.out.println(nonUnique);

    }
}
