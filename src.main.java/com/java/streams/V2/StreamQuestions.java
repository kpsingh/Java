package com.java.streams.V2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamQuestions {
    public static void main(String[] args) {
        ///Q. Find the longest string in a list of strings using Java streams:
        List<String> names = Arrays.asList("KP", "Modi", "Ramayan", "Mahabharat");
        names.stream().sorted((s1, s2) -> s2.length() - s1.length()).limit(1).forEach(System.out::println);
        names.stream().max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        names.stream().max((s1, s2) -> s1.length() - s2.length()).ifPresent(System.out::println);

    }
}
