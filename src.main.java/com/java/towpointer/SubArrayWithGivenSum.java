package com.java.towpointer;

/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which
adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int target = 5;
        List<Integer> result = solve(list, target);
        System.out.println(result);
    }

    private static List<Integer> solve(List<Integer> list, int target){
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0;
        int sum = 0;

        for(int hi = 0; hi < list.size(); hi++){
            sum += list.get(hi); // expand the window

            while(sum > target && low <= hi){ // reduce the window if needed
                sum -= list.get(low);
                low++;
            }
            if(sum == target){
                return new ArrayList<>(list.subList(low, hi + 1));
            }
        }

        result.add(-1); // if no subarray found
        return  result;
    }
}
