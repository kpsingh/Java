package com.java.practice.map;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(5,4));
        map.put(2, Arrays.asList(6,7));
        map.put(3, Arrays.asList(8,9));

        List<int[]> stream = map.entrySet().stream().map(e -> e.getValue().stream().mapToInt(i -> i).toArray()).collect(Collectors.toList());
        new ArrayList<>(stream);


    }
}
