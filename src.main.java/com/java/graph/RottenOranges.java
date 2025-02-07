package com.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int ans = bfs(arr);
        System.out.println(ans);

    }

    public static int bfs(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    q.add(new Pair(i, j)); // collect all rotten oranges (multi source bfs)
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            // explore all the 4 option and see which can be valid case to put into the queue
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if (validCell(arr, ni, nj)) { // check if it is fresh orange
                    arr[ni][nj] = 2; // make the orange as rotten
                    q.offer(new Pair(ni, nj)); // add to the que so that adjucent to it can be rotten in next minutes
                }
            }
        }

        return  -1;
    }
    private static boolean validCell(int[][] arr, int i, int j) {
        return i >=0 && j >= 0 && i<arr.length && j<arr[0].length && arr[i][j] == 1; // if fresh orange
    }
}
