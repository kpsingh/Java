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
        int freshCount = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    freshCount++; // count the fresh orange
                } else if (arr[i][j] == 2) {
                    queue.add(new Pair(i, j)); // rotten orange can be one of source for bfs
                }
            }
        }
        if (freshCount == 0) {
            return 0; // that mean all oranges are already rotten
        }
        int time = -1;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int s = 0; s < size; s++) { // all orange in this level get rotten in same time
                Pair pair = queue.poll();
                int i = pair.i, j = pair.j;

                for (int k = 0; k < dx.length; k++) { // explore all 4 option from the current node
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (validCell(arr, ni, nj)) {
                        arr[ni][nj] = 2; // this orange got rotten
                        freshCount--; // reduce one fresh orange
                        queue.add(new Pair(ni, nj)); // put into the que
                    }
                }
            }
        }
        return freshCount == 0 ? time : -1; // if any fresh count then return -1;
    }

    private static boolean validCell(int[][] arr, int i, int j) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[0].length && arr[i][j] == 1; // if fresh orange
    }
}
