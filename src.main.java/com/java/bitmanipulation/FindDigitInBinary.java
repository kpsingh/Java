package com.java.bitmanipulation;

public class FindDigitInBinary {
    public static void main(String[] args) {
        int n = 14;
        // Build in library
        String binary = Integer.toBinaryString(n);

        System.out.println("Java Library : " + binary);
        // custom code
        binary = toBinaryString(n);
        System.out.println("Custom Code : " + binary);

    }

    private static String toBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }
}
