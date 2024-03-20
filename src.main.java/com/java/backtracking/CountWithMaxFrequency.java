package com.java.backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CountWithMaxFrequency {
    public static void main(String[] args) {
        //int[] arr = {1,2,2,3,1,4};
        int[] arr = {1,2,3,5,4};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a , 0) + 1);
        }

        List<Integer> list = map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).map(e -> e.getValue()).collect(Collectors.toList());
        map.values();

        int x = list.get(0);
        int sum = x;
        for(int i = 1; i < list.size(); i++){
            if (list.get(i) == x){
                sum += list.get(i);
            }else{
                break;
            }
        }
        System.out.println(sum);

    }
}
