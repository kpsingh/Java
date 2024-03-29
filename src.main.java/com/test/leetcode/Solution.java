package com.test.leetcode;

public class Solution {

    public static void main(String[] args) {
        String A = "e[exe]c";
        String B = "e";
        String C = "g";
        String ans = FindAndReplace(A, B, C);
        System.out.println(ans);

    }


    public static  String FindAndReplace(String A, String B, String C) {
        char[] arr = A.toCharArray();
        int start = 0;
        int end = 0;
        boolean isFound = false;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == '['){
                isFound = true;
            }
            else if (arr[i] == ']'){
                isFound = false;
            }

            else if (isFound && String.valueOf(arr[i]).equals(B)){
                arr[i] = C.charAt(0);
            }
        }

        return new String(arr);
    }
}
