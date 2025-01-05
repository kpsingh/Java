package com.java.practice.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubsequenceOfString {

    static private Set<String> allSubSeq = new HashSet<>();

    public static void main(String[] args) {
        String str = "aabca";
        int ans = countPalindromicSubsequence(str);
        System.out.println(ans);

    }

    public static int countPalindromicSubsequence(String str) {
        calculatePalinSubse(str, 0, "");
        int a = (int) allSubSeq.stream().filter(s -> s.length() == 3 && isPalindrom(s)).count();
        return a;
    }

    private static void calculatePalinSubse(String s, int i, String subSeq) {
        if (i == s.length()) {
            allSubSeq.add(subSeq);
            return;
        }
        calculatePalinSubse(s, i + 1, subSeq);
        calculatePalinSubse(s, i + 1, subSeq + s.charAt(i));

    }

    private static boolean isPalindrom(String s) {
        return s.charAt(0) == s.charAt(s.length() - 1);
    }

}
