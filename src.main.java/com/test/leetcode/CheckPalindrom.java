package com.test.leetcode;

public class CheckPalindrom {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,2,1};

        int i= 0;
        int j = arr.length -1;

        boolean isPalindrom = true;

        while (i < j){
            if (arr[i] != arr[j]){
                isPalindrom = false;
                break;
            }
            else{
                i++;
                j--;
            }
        }

        if(isPalindrom){
            System.out.println(" Its is Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }




    }
}
