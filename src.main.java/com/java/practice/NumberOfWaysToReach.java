package com.java.practice;

public class NumberOfWaysToReach {
    public static void main(String[] args) {
        int a = 5;

    }

    private int numberOfWays(int a) {
        int mod = 1000000007;
        int[] dp = new int[a + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= a; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[a];
    }
}