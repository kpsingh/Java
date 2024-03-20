package com.java.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class AllPermutations {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        printPermutes(arr, new HashSet<Integer>(), new ArrayList<Integer>());
    }

    private static void printPermutes(int[] arr, HashSet<Integer> set, ArrayList<Integer> list) {
        if(list.size() == arr.length){
            System.out.println(list);
        }
        for(int a : arr){
            if(!set.contains(a)){
                set.add(a);
                list.add(a);

                printPermutes(arr, set, list);

                list.remove(list.size()-1);
                set.remove(a);
            }
        }
    }
}
