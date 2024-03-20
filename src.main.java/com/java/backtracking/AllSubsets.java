package com.java.backtracking;

import java.util.ArrayList;

public class AllSubsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        generateSubsets(arr, 0, new ArrayList<Integer>());
    }

    private static void generateSubsets(int[] arr, int index, ArrayList<Integer> list) {
        if (index == arr.length){
            System.out.println(list);
            return;
        }
        // we have two choice : choose or not choose he current element then call to magic function
        generateSubsets(arr, index + 1, list); // not choose

        list.add(arr[index]); // choose
        generateSubsets(arr, index + 1, list);
        list.remove(list.size()-1);
    }
}
