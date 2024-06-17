package com.java.bitmanipulation;

import java.util.Map;

public class ReverseBits {
    public static void main(String[] args) {
        long n = 3;
        String bits = Long.toBinaryString(n);
        System.out.println(bits);
        StringBuilder sb = new StringBuilder(bits);
        bits = sb.reverse().toString();
        System.out.println(bits);
        System.out.println("*************");

        // get the 32 bit number representation for the given number

        StringBuilder sb2 = new StringBuilder();
        for(int i = 31; i >= 0; i--) {
            if ((n >> i & 1) == 1){
                sb2.append(1);
            }else{
                sb2.append(0);
            }
        }
        System.out.println(sb2.toString());
        String reversedBits = sb2.reverse().toString();
        System.out.println(reversedBits);

        long ans = 0;
        String temp = sb2.toString();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1'){
                ans += (2 << i);
            }
        }
        System.out.println(ans);





    }
}
