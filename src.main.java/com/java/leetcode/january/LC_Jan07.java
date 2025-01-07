package com.java.leetcode.january;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
https://leetcode.com/problems/string-matching-in-an-array/description/
 */
public class LC_Jan07 {

    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        ArrayList<String> result = new ArrayList<>();

        for(int i = 0 ; i < words.length ; i++){
            for(int j = i+1 ; j < words.length ; j++){
                if(words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
