package com.java.leetcode.january;
/*
3042. Count Prefix and Suffix Pairs I
https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/
 */
public class LC_Jan08 {
    public static void main(String[] args) {
        String[] words = {"pa","papa","ma","mama"};
        int n = countPrefixSuffixPairs(words);
        System.out.println(n);
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])){
                    count++;
                }
            }
        }
        return  count;
    }
}
