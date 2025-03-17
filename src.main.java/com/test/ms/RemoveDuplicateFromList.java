package com.test.ms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateFromList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1);

        // way one - using the stream API.
       // list.stream().distinct().toList().forEach(System.out::println);

        // way two - convert to set directly
        Set<Integer> set = new HashSet<>(list);
        System.out.println(set);



    }
}
