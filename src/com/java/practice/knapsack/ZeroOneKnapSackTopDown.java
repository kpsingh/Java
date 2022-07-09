package com.java.practice.knapsack;

public class ZeroOneKnapSackTopDown {
	
	public static void main(String[] args) {
		int val[] = new int[] { 50, 75, 175, 110, 155 };
		int wt[] = new int[] { 50, 75, 175, 110, 155 };
		int w = 200; // max wait a vehicle can carry
		int n = val.length; // Number of items available to pick.
		
		int[][] t = new int[n+1][w+1];
		
		
		
		
		

	}

}


//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
 public int solution(int[] A) {
     // write your code in Java SE 8

     Map<Integer, Boolean> map = new HashMap<>();

     for(int i = 0; i< A.length; i++){
         
         if (map.get(A[i]) != true){
             map.put(A[i], true);
         }
         
     }
     int ans = 1;

     for(int i = 1; i <= 1000000; i++){
         if (map.get(i) != true) {
             ans = i;
         }

     }

     return ans;
 }
}
