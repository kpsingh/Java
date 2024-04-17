package com.test.leetcode;

import java.util.List;

/*
Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []

 */
public class FindDuplicate {
    public static void main(String[] args) {

        List<Integer> list = List.of(3,4,6,8,9,66,5,44,33,23,45,67);

        int result = list.stream().mapToInt(a -> a).sorted().skip(1).min().getAsInt();

        System.out.println(result);
    }
}
