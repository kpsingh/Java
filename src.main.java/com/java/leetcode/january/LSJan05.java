package com.java.leetcode.january;

/*
https://leetcode.com/problems/shifting-letters-ii/
 */

public class LSJan05 {
    public static void main(String[] args) {
        String str = "abc";
        char[] ch = str.toCharArray();
        for (int i = 0, d = 0; i <= 1; i++) {
            if(d == 0){
                if(ch[i] == 'a') ch[i] = 'z';
                else ch[i]--;
            }else{
                if(ch[i] == 'z') ch[i] = 'a';
                else ch[i]++;
            }
        }

        System.out.println(new String(ch));
      //  System.out.println('a' == 97);
        //System.out.println('z' == 122);
    }

}
