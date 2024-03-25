package com.java.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/description/
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
 */

public class RottingOranges {
    public static void main(String[] args) {
      //  int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] arr = {{2, 1, 1}, {0, 1, 1}, {1,0,1}};
        int result = orangesRotting(arr);
        System.out.println(result);
    }

    public static int orangesRotting(int[][] arr) {
        int freshOranges = 0;
        Queue<Grid> q = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1){
                    freshOranges++;
                }
                if (arr[i][j] == 2){
                    // capture the rotten orange in the queue which will be used to do bfs (level order traversal)
                    q.add(new Grid(i,j));
                }
            }
        }
        if (freshOranges == 0) return 0; // as all are already rotten

        int time = 0; // at time t = 0 we have list of all rotten orange.. now do the bfs from here
        while (!q.isEmpty()){
           int level = q.size();
           time++; // latter the final time we'll decrease by 1
           for(int i = 0; i < level; i++){
               Grid grid = q.poll();
               // from a grid there is 4 move possible,
               int[] X = {0,-1,0,1};
               int[] Y = {1,0,-1,0};
               for(int k = 0; k < X.length; k++){
                   int newI = grid.i + X[k];
                   int newJ = grid.j + Y[k];
                   if (isValid(newI, newJ, arr)){
                       arr[newI][newJ] = 2; // make them rotten
                       q.add(new Grid(newI, newJ));
                       freshOranges--;
                   }
               }
           }
        }

        // check if any orange left
        if (freshOranges > 0) return -1;

        return time - 1;
    }

    private static boolean isValid(int i, int j, int[][] arr) {
       if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0 || arr[i][j] == 2)
           return  false;
       else
           return  true;
    }
}

class Grid{
    int i;
    int j;
    public Grid(int i, int j){
        this.i = i;
        this.j = j;
    }
}
